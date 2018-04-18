package classes;

import java.util.Comparator;

public class Product {

    private int sales = 0;
    private double price;
    private String name;

    public Product(){}

    public Product(String name, double price){
        this.setName(name);
        this.setPrice(price);
    }

    //Multiple Comparators
    static Comparator<Product> bySales(){
        return new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getSales() - o1.getSales();
            }
        };
    }
    static Comparator<Product> byPrice(){
        return new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        };
    }

    @Override
    public String toString(){
        return "Name: "+ getName() +", price: " + getPrice() + ", sales: "+ getSales();
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateSales(int quantity){
        sales +=quantity;
    }
}
