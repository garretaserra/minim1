package classes;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotationImpl implements ReversePolishNotation {

    String operacion;
    Stack<Character> pila= new Stack<Character>();
    int num1;
    int num2;

    public ReversePolishNotationImpl(String operacion){
        this.operacion = operacion;
    }

    void stringToStack(String op){
        for(int i = op.length(); i>=0;i--){
            pila.push(op.charAt(i));
        }
    }

    public int calculateResult(){
        stringToStack(operacion);
        List<Character> list = new ArrayList<>();
        for(int i = 0; i<operacion.length();i++){
            list.add(operacion.charAt(i));
        }
        while(!pila.empty()){
            char c = pila.pop();
            switch (c) {
                case '+':
                    num1 = Character.getNumericValue(pila.pop());
                    num2 = Character.getNumericValue(pila.pop());
                    pila.push(((char) (num1 + num2)));
                    break;
                case '-':
                    num1 = Character.getNumericValue(pila.pop());
                    num2 = Character.getNumericValue(pila.pop());
                    pila.push(((char) (num1 - num2)));
                    break;
                case '*':
                    num1 = Character.getNumericValue(pila.pop());
                    num2 = Character.getNumericValue(pila.pop());
                    pila.push(((char) (num1 * num2)));
                    break;
                case '/':
                    num1 = Character.getNumericValue(pila.pop());
                    num2 = Character.getNumericValue(pila.pop());
                    pila.push(((char) (num1 / num2)));
                    break;
                default:
                    pila.push(c);
            }
        }
        return pila.pop();
    }


}
