package Queue;

public interface Queue <T>{

    int size();
    void add(T obj) throws FullQueue;
    T get() throws EmptyQueue;

}
