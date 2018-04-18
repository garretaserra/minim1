import Queue.*;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QueueTest {
    @Test
    public void queueTest(){
        final int length = 5;
        QueueImp<Integer> queue = new QueueImp<>();
        try {
            for (int i = 0; i < length; i++) {
                queue.add(i);
            }
        }
        catch (FullQueue e){

        }
        assertEquals(queue.size(),length);
        try {
            for (int i = 0; i < length; i++) {
                assertTrue(queue.get()==i);
            }
        }
        catch (EmptyQueue e){

        }
    }

    @Test(expected = EmptyQueue.class)
    public void emptyQueueTest() throws EmptyQueue{
        QueueImp<Integer> queue = new QueueImp<>();
        queue.get();
    }

    @Test(expected = FullQueue.class)
    public void fullQueueTesst() throws FullQueue{
        QueueImp<Integer> queue = new QueueImp<Integer>();
        for(int i = 0; i<= QueueImp.max; i++){
            queue.add(i);
        }
    }
}
