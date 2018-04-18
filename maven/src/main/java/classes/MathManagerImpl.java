package classes;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MathManagerImpl implements MathManager {

    private static final Logger log = LogManager.getLogger(MathManagerImpl.class.getName());

    private static MathManagerImpl instance;
    private HashMap<String,Alumno> alumnos = new HashMap<>();
    private List<Instituto> institutos = new ArrayList<>();
    private Queue<Operacion> cola = new LinkedList<>();

    private MathManagerImpl(){}

    public static MathManagerImpl getInstance(){
        if(instance == null){
            instance = new MathManagerImpl();
            log.info("Instancia de MathManagerIMpl creada");
        }
        return instance;
    }

    public static void delete(){
        instance = null;    //Permite reiniciar la base de datos
        log.info("Instancia MathManagerImpl borrada");
    }


    @Override
    public int procesarOperacion() {
        Operacion op = getCola().poll();
        //call processor


        return 0;
    }

    @Override
    public List<Operacion> listadoOperacionesInstituto(String instituto) {
        List<Operacion> operaciones = new LinkedList<>();
        for(Instituto ins : institutos){
            if(ins.getNombre().equals(instituto)){
                for(Alumno alumno : ins.getAlumnos()){
                    operaciones.addAll(alumno.getOperaciones());
                }
                log.info("Devuelto el listado de operaciones de todos los alumnos de un instituto");
                return operaciones;
            }
        }
        log.warn("Intento de encontrar el instituto "+instituto+" que no existe");
        return null;
    }

    @Override
    public List<Operacion> listadoOperacionesAlumno(String alumno) {
        List<Operacion> list = alumnos.get(alumno).getOperaciones();
        if(list == null){
            log.warn("No existe el alumno buscado: "+alumno);
        }
        if(list.size()==0){
            log.info("Pedida la lista de operaciones de: "+alumno+" que no tiene operaciones previas");
        }
        log.info("Devueltas todas las operaciones del alumno: "+alumno);
        return list;
    }

    @Override
    public List<Instituto> listadoInsitutos() {
        List<Instituto> list = new LinkedList<>(institutos);
        if(list.size() == 0){
            log.info("Listado de Institutos esta vacio");
        }
        list.sort(Instituto.comparador());
        log.info("Listado de instituto devuelto ordenado por cantidad de operaciones de sus alumnos");
        return list;
    }


    //Getters i Setters
    public HashMap<String, Alumno> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(HashMap<String, Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    public List<Instituto> getInstitutos() {
        return institutos;
    }
    public void setInstitutos(List<Instituto> institutos) {
        this.institutos = institutos;
    }

    public void añadirAlumno(String name, String instituto){
        for(Instituto ins : institutos){
            if(ins.getNombre().equals(instituto)){
                Alumno a = new Alumno(name,ins);
                this.alumnos.put(name,a);
                ins.getAlumnos().add(a);
                log.info("Alumno: "+name+" con instituto: "+instituto+" añadido");
                return;
            }
        }
        log.warn("Se ha intentado añadir a un alumno a un instituto: "+instituto+", que no existe");
    }
    public void añadirInstituto(String name){
        institutos.add(new Instituto(name));
        log.info("Añadido instituto: "+name);
    }
    public void realizarOperacion(String alumno, Operacion operacion){
        Alumno a = alumnos.get(alumno);
        operacion.setPropietario(a);
        getCola().add(operacion);
        a.getInstituto().addToCount();
    }

    public Queue<Operacion> getCola() {
        return cola;
    }

    public void setCola(Queue<Operacion> cola) {
        this.cola = cola;
    }
}
