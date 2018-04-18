package services;

import javax.ws.rs.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import classes.Instituto;
import classes.MathManagerImpl;
import classes.Operacion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


@Path("/service")
public class Server {
    private static final Logger log = LogManager.getLogger(Server.class.getName());

    @GET
    @Path("/listadoOperacionesInstituto/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operacion> listadoOperacionesInstituto(@PathParam("nombre") String instituto){
        return MathManagerImpl.getInstance().listadoOperacionesInstituto(instituto);
    }

    @GET
    @Path("/listadoOperacionesAlumno/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operacion> listadoOperacionesAlumno(@PathParam("nombre") String alumno){
        return MathManagerImpl.getInstance().listadoOperacionesAlumno(alumno);
    }

    @GET
    @Path("/listadoInstitutos")
    @Produces(MediaType.APPLICATION_JSON)
    //Estan ordenados
    public List<Instituto> listadoInstitutos(){
        return MathManagerImpl.getInstance().listadoInsitutos();
    }

    @GET
    @Path("/processarOrder")
    @Produces(MediaType.TEXT_PLAIN)
    public String procesadOrder(){
        return String.valueOf(MathManagerImpl.getInstance().procesarOperacion());
    }

    @POST
    @Path("/realizarOperacion/{nombre}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void realizarOperacion (@PathParam("nombre") String alumno, Operacion operacion){
        MathManagerImpl.getInstance().realizarOperacion(alumno,operacion);
    }
}
