package classes;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Instituto {

    private String nombre;
    private List<Alumno> alumnos = new LinkedList<>();
    private int count = 0;

    public Instituto(){}

    public Instituto(String nombre){
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int addToCount(){
        return ++this.count;
    }

    public static Comparator<Instituto> comparador(){
        return new Comparator<Instituto>() {
            @Override
            public int compare(Instituto o1, Instituto o2) {
                return o1.getCount()-o2.getCount();
            }
        };
    }

}
