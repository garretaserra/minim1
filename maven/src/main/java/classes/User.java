package classes;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static int num = 0;     //Cantidad de usuarios registrados
    String name;

    Order order = new Order();
    List<Order> servedOrders = new ArrayList<>();

    public User(){}

    public User(String name){
        this.name = name;
        this.order.setOwner(name);
    }

    @Override
    public String toString(){
        return "Nombre: "+ name;
    }

    public void addProducttoOrder(classes.Product product, int quantity){
        order.cart.add(new ProductQuantity(product,quantity));
    }

    public Order addServedOrder(Order order){
        servedOrders.add(order);
        return order;
    }

    public Order getOrder(){
        return this.order;
    }

    public List<Order> getFullfilledOrders(){
        return this.servedOrders;
    }

}
