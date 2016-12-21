package ds.util.vector;

@SuppressWarnings("unchecked")
public class LinkedList<T> {
    private LinkedList<T> next;
    private int index;
    private T data;

    public LinkedList() {
        this(0);
    }

    public LinkedList(index) {
        this.index = index;
    }

    public int size() {
        return this.index;
    }

    public boolean add(T t) {
        return true;
    }

    public T get(int i) {
        if (i == 0) {
            return this.data;
        }
        if(this.next == null) {
            throw new IndexOutOfBoundsException();
        }
        return next.get(i-1); 
    }

    public boolean contains(T t) {
        if(this.data.equals(t)) {
            return true;
        }
        if(this.next != null) {
            return this.next.contains(t);
        }
        return false;
    }

    public int indexOf(T t) {
        if(t.equals(this.data)) {
            return this.index;
        }
        else {
            return this.next.indexOf(t);
        }
    }

    public boolean remove(T t) {
        return false;
    }

    public T remove(int index) {
        return null;
    }

    public T set(int index, T t) {
        return t;
    }

    public void add(int index, T t) {
        return;
    }

}
