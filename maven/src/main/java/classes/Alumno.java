package classes;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

    private String nombre;
    private Instituto instituto;
    private List<Operacion> operaciones = new ArrayList<>();

    public Alumno(){}

    public Alumno(String nombre, Instituto instituto){
        this.nombre = nombre;
        this.instituto = instituto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;
    }

    public List<Operacion> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operacion> operaciones) {
        this.operaciones = operaciones;
    }
}
