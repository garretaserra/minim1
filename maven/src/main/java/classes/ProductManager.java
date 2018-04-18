package classes;

import java.util.List;

public interface ProductManager {

    List<Product> productListPrice();               //Listado de productos ordenados por precio (ascendentemente)
    List<Product> productListSales();               //Listado de productos ordenados por ventas (descendentemente)
    boolean comitOrder(User user, Order order);                     //Realizar pedido de un usuario
    boolean fulfillOrder();                            //Servir el siguiente pedido en la cola
    List<Order> fulfilledOrders(User user);         //Listado de pedidos ya realizados de ese usuario

}
