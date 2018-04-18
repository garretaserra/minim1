package classes;

import java.util.List;

public interface MathManager {

    public void realizarOperacion(String alumno, Operacion operacion);
    public int procesarOperacion();
    public List<Operacion> listadoOperacionesInstituto(String instituto);
    public List<Operacion> listadoOperacionesAlumno(String alumno);
    public List<Instituto> listadoInsitutos();

}
