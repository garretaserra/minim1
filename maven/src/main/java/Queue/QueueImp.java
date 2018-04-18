package Queue;

public class QueueImp<T> implements Queue<T> {

    private T[] arrayObjects;
    private int size;
    public static final int max = 50;

    @SuppressWarnings("unchecked")
    public QueueImp(){
        this.arrayObjects = (T[]) new Object[max];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T obj) throws FullQueue {
        if(size<max){
            arrayObjects[size++] = obj;
        }
        else {
            throw new FullQueue();
        }
    }

    @Override
    public T get() throws EmptyQueue {
        if(0<size){
            T temp = (T)new Object();
            temp = arrayObjects[0];
            for(int i = 0; i<size && i<max-1; i++){
                arrayObjects[i] = arrayObjects[i+1];
            }
            arrayObjects[size()] = null;
            size--;
            return temp;
        }
        else {
            throw new EmptyQueue();
        }
    }
}
