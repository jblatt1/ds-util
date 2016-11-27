package ds.util.vector;

import ds.util.vector.ArrayList;

@SuppressWarnings("unchecked")
public class Stack<T> {
    private ArrayList<T> list;

    public Stack() {
        this(10);
    }

    public Stack(int capacity) {
        this.list = new ArrayList<T>(capacity);
    }

    public int size() {
        return this.list.size();
    }

    public boolean push(T t) {
        return this.list.add(0, t);
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
