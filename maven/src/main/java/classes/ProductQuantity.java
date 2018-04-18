package classes;

public class ProductQuantity {

    classes.Product product;
    int quantity;

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductQuantity(){}

    public ProductQuantity(classes.Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct(){
        return this.product;
    }

    public int getQuantity(){
        return quantity;
    }
}
