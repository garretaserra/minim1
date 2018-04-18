import classes.Product;
import classes.ProductManagerImp;
import classes.User;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SortingTest {

    @Before
    public void setup(){
        ProductManagerImp PIM = ProductManagerImp.getInstance();

        PIM.addUser(new User("Sergi"));
        PIM.addUser(new User("Marc"));

        PIM.addProduct(new Product("Cafe", 1.10));
        PIM.addProduct(new Product("Aigua", 1.00));
        PIM.addProduct(new Product("Menu", 6.35));
    }

    @After
    public void tearDown(){
        ProductManagerImp.getInstance().delete();
    }

    @Test
    public void orderbyPrice(){
        List<Product> list = ProductManagerImp.getInstance().productListPrice();
        for(int i = 0; i<list.size()-1; i++){
            assertTrue("el precio de " + list.get(i).getName() + " no es mas pequeño o igual que el precio de "+ list.get(i + 1).getName(),
                    list.get(i).getPrice() <= list.get(i + 1).getPrice());
        }
    }

    @Test
    public void orderbySales() {
        List<Product> list = ProductManagerImp.getInstance().productListSales();
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue("las ventas de " + list.get(i).getName() + " no son mas grandes o iguales a " + list.get(i).getName(),
                    list.get(i).getSales() >= list.get(i).getSales());
        }
    }
}
