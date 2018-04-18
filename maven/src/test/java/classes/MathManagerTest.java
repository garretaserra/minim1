package classes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MathManagerTest {


    @Before
    public void setUp(){
        MathManagerImpl.getInstance().añadirInstituto("Sunion");
        MathManagerImpl.getInstance().añadirInstituto("Cic");
        MathManagerImpl.getInstance().añadirAlumno("Sergi","Sunion");
        MathManagerImpl.getInstance().añadirAlumno("Maria", "Cic");
    }

    @After
    public void tearDown(){
        MathManagerImpl.getInstance().delete();
    }

    @Test
    public void realizarOperacion(){
        Operacion op = new Operacion("53+");
        MathManagerImpl.getInstance().realizarOperacion("Sergi",op);
        assertEquals(MathManagerImpl.getInstance().getCola().size(), 1);
    }

    @Test
    public void procesarOperacion(){
        int num = MathManagerImpl.getInstance().getCola().size();
        MathManagerImpl.getInstance().procesarOperacion();
        assertTrue(num==0||MathManagerImpl.getInstance().getCola().size()==num-1);//La cola es una peticion menos que anterior o 0
    }
}
