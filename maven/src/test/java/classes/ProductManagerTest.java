package classes;

import Queue.Queue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProductManagerTest {
    ProductManagerImp pm;

    @Before
    public void setUp() {
        pm = ProductManagerImp.getInstance();

        // Users
        // Productes al cataleg
    }

    @After
    public void tearDown() {

    }


    @Test
    public void commitOrder() {
        Order o1  = new Order();
        //Add Products to order
        User u1 = pm.getUser("Sergi");
        this.pm.comitOrder(u1, o1);
        //Check if order is now empty

        //classes.Product p = new classes.Product();
    }

    @Test
    public void fullFilled() {
        //Make diferent orders and fullFill them one by one

        //Order o = this.pm.fulfillOrder();
        //AssertionError(o.owner(), "Sergi")

    }

}
