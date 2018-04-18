package services;

import Main.Main;
import classes.Product;
import classes.ProductManagerImp;
import classes.User;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ServerTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setup(){
        server = Main.startServer();
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown(){
        server.shutdown();
    }

    @Test
    public void hello(){
        String response = target.path("/service/hello").request().get(String.class);
        assertEquals(response,"Hello, World");
    }

    @Test
    public void commitOrder(){
        ProductManagerImp.getInstance().addUser(new User("Sergi"));
        ProductManagerImp.getInstance().addUser(new User("Marc"));
        ProductManagerImp.getInstance().addProduct(new Product("Cafe", 1.10));
        ProductManagerImp.getInstance().addProduct(new Product("Aigua", 1.00));


        User u = ProductManagerImp.getInstance().getUser("Sergi");
        Product p = ProductManagerImp.getInstance().getProduct("Cafe");
        u.addProducttoOrder(p,2);
        //String response = target.path("/service/comitorder?");
    }
}
