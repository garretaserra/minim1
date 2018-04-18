package services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import classes.*;
import classes.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static classes.ProductManagerImp.*;


@Path("/service")
public class Services {

    private static final Logger log = LogManager.getLogger(ProductManager.class.getName());

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello, World";
    }

    @GET
    @Path("/listbyprice")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listbyPrice() {
        List<Product> list = getInstance().productListPrice();
        JSONArray ja = new JSONArray(list);
        return Response.status(Response.Status.OK).entity(ja.toString()).build();
    }

    @GET
    @Path("/listbysales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listbysales() {
        return Response.status(Response.Status.OK).entity(
                new JSONArray(getInstance().productListSales())).build();
    }

    @GET
    @Path("/serveOrder")
    @Produces(MediaType.TEXT_PLAIN)
    public String serveOrder() {
        return String.valueOf(getInstance().fulfillOrder());
    }

    @GET
    @Path("/fullfilledorders/{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public String fullFilledOrders(@PathParam("username") String username) {
        User u = new User(username);
        getInstance().addUser(u);
        Product p = new Product("Aigua", 1.00);
        getInstance().addProduct(p);
        getInstance().getUser(username).addProducttoOrder(p,1);
        getInstance().comitOrder(u,u.getOrder());
        getInstance().fulfillOrder();
        log.info(getInstance().getUser(username).getFullfilledOrders().get(0).getProductQuantity().get(0).getProduct().getName());
        List<JSONObject> list = new ArrayList<>();
        for(Order order : getInstance().getUser(username).getFullfilledOrders()){
            JSONArray ja = new JSONArray(order.getProductQuantity());
            JSONObject jo = new JSONObject();
            jo.put("owner",order.getOwner());
            jo.put("productQuantity", ja);
            list.add(jo);
        }
        JSONArray res = new JSONArray(list);
        return res.toString();
    }

}
