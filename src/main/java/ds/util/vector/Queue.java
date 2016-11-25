package ds.util.vector;

import ds.util.vector.ArrayList;

@SuppressWarnings("unchecked")
public class Queue<T> {
    private ArrayList<T> list;

    public Queue() {
        this(10);
    }

    public Queue(int capacity) {
        this.list = new ArrayList<T>(capacity);
    }

    public int size() {
        return this.list.size();
    }

    public boolean push(T t) {
        return this.list.add(t);
    }

    public T peek() {
        return (T) this.list.get(0);
    }

    public T pop() {
        return this.list.remove(0);
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}
