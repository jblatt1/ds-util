package ds.util.vector;

@SuppressWarnings("unchecked")
public class ArrayList<T> {
    private Object[] items;
    private int size;
    private int capacity;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.grow(); 
    }

    private void grow() {
        if(this.size < this.capacity/2 && this.items != null) {
            // no need to grow
            return;
        }
        this.capacity *= 2;
        Object[] items = this.items;
        this.items = new Object[this.capacity];
        for(int i=0; i<this.size; i++) {
            this.items[i] = (T) items[i];
        }
    }

    private void shrink() {
        if (this.size > this.capacity/4) {
            return;
        }
        this.capacity /= 2;
        Object[] items = this.items;
        this.items = new Object[this.capacity];
        for(int i=0; i<this.size; i++) {
            this.items[i] = (T) items[i];
        }
    }

    private void rangeCheck(int index) {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return this.size;
    }

    public boolean add(T t) {
        this.grow();
        this.items[this.size++] = t;
        return true;
    }

    public T get(int i) {
        this.rangeCheck(i);
        return (T) this.items[i];
    }

    public boolean contains(T t) {
        return this.indexOf(t) != -1;
    }

    public int indexOf(T t) {
        for(int i=0; i<this.size; i++) {
            if(this.get(i).equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(T t) {
        int index = this.indexOf(t);
        if(index == -1) {
            return false;
        }
        return this.remove(index) != null;
    }

    public T remove(int index) {
        T item = this.get(index);
        for(int i=index; i<this.size-1; i++) {
            this.items[i] = this.items[i+1];
        }
        this.size--;
        this.shrink();
        return item;
    }

    public T set(int index, T t) {
        T oldVal = this.get(index);
        this.items[index] = t;
        return oldVal;
    }

    public void add(int index, T t) {
        this.rangeCheck(index);
        this.grow();
        for(int i=this.size+1; i<index; i--) {
            this.items[i] = this.items[i-1];
        }
        this.items[index] = t;
    }

}
