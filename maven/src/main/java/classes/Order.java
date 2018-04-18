package classes;

import java.util.LinkedList;
import java.util.List;

public class Order {

    List<ProductQuantity> cart = new LinkedList<>();
    String owner;

    public Order(){}

    public void setOwner(String owner){
        this.owner = owner;
    }

    public String getOwner(){
        return this.owner;
    }

    public List<ProductQuantity> getProductQuantity(){
        return cart;
    }

    public void addProductQuantity(Product product, int quantity){
        cart.add(new ProductQuantity(product,quantity));
    }

}
