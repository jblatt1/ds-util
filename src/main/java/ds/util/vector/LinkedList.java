package ds.util.vector;

@SuppressWarnings("unchecked")
public class LinkedList<T> {
    private LinkedList<T> next;
    private int size;
    private T data;

    public LinkedList() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean add(T t) {
        return true;
    }

    public T get(int i) {
        if(this.size <= i) {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0) {
            return this.data;
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
        return -1;
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
