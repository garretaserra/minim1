package classes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReversePolishNotationTest {

    @Test
    public void procesarCalculo(){
        ReversePolishNotationImpl rpn = new ReversePolishNotationImpl("53+");
        assertEquals(rpn.calculateResult(),7);
    }
}
