package classes;

import Queue.EmptyQueue;
import Queue.FullQueue;
import Queue.QueueImp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ProductManagerImp implements ProductManager {

    private static ProductManagerImp instance;
    private HashMap<String, User> users;
    private List<classes.Product> products;
    private QueueImp<Order> queue = new QueueImp<Order>();
    private static final Logger log = LogManager.getLogger(ProductManager.class.getName());

    private ProductManagerImp() //Constructor privado para controlar instancia única
    {
        users = new HashMap<>();
        products = new ArrayList<>();   //ArrayList por que no hay muchos cambios y si muchas consultas
//        Queue<Order> cua = new LinkedList<Order>();
    }

    public static ProductManagerImp getInstance(){
        if(instance == null){
            instance = new ProductManagerImp(); //Crear instancia si no hay
            log.info("Instancia de classes.ProductManagerImp creada");
        }
        return instance;
    }

    public void delete(){
        instance = null;
        log.info("Instáncia de ProductManager borrada");
    }

    public void addUser(User user){
        users.put(user.name,user);
        log.info("usuario añadido: "+user.toString());
    }

    public User getUser(String name){
        return users.get(name);
    }

    @Override
    public List<classes.Product> productListPrice() {
        log.info("Lista de productos por precio");
        List<classes.Product> list = new ArrayList<>(products); //Crear copia de la lista
        list.sort(classes.Product.byPrice());       //Ordenar por precio
        return list;
    }

    @Override
    public List<classes.Product> productListSales() {
        log.info("Lista de productos por ventas");
        List<classes.Product> list = new ArrayList<>(products); //Crear copia de la lista
        list.sort(classes.Product.bySales());      //Ordenar por ventas
        return list;
    }

    @Override
    public boolean comitOrder(User user, Order order){
        log.info("USER "+user);
        try{
            queue.add(order);
            log.info("Pedido realizado por "+user.name);
            return true;
        }
        catch (FullQueue e){
            log.warn("Pedido de "+ user.name + " no se pudo realizar, cola llena");
            return false;
        }
    }

    private void processOrder(Order order) {
        log.info("Procesando order");
        List<ProductQuantity> lp = order.getProductQuantity();

        for (ProductQuantity pq: lp) {
            pq.getProduct().updateSales(pq.getQuantity());
        }

    }

    @Override
    public boolean fulfillOrder() {
        try {
            Order order = queue.get();
            processOrder(order);
            users.get(order.owner).addServedOrder(order);
            return true;
        }
        catch (EmptyQueue e){
            log.warn("Intento de obtener pedido de la cola cuando esta vacía");
            return false;
        }
    }

    @Override
    public List<Order> fulfilledOrders(User user) {
        log.info("Pedidos realizados por usuario: "+user.name);
        List<Order> list = user.servedOrders;
        return list;
    }

    public List<Order> fulfilledOrders(int id){
        return fulfilledOrders(users.get(id));
    }

    public classes.Product getProduct(String name) {
        for(classes.Product p : products)
        {
            if(p.getName().equals(name)) {
                log.info("Producto: "+ p.getName() +" encontrado");
                return p;
            }
        }
        log.warn("Busqueda de un producto por nobre que no existe : " + name);
        return null;
    }

    public void addProduct(classes.Product product) {
        products.add(product);
        log.info("Producto añadido: " +product.toString());
    }

    public void addProducttoOrder(int userid, String productName, int quantity){
        users.get(userid).addProducttoOrder(getProduct(productName),quantity);
    }
}
