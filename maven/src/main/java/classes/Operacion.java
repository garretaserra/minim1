package classes;


public class Operacion {

    private String operacion;
    private Alumno propietario;

    public Operacion(String operacion) {
        this.operacion = operacion;
    }

    public Operacion(){}

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Alumno getPropietario() {
        return propietario;
    }

    public void setPropietario(Alumno propietario) {
        this.propietario = propietario;
    }
}
