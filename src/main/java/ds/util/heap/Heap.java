package ds.util.heap;

public class Heap<T extends Comparable<T>> {
    Object[] items;
    int size;
    int capacity;

    public Heap() {
        this(1<<4);
    }

    private Heap(int capacity) {
        this.capacity = capacity;
        this.items = new Object[this.capacity];
        this.size = 0;
    }

    public boolean add(T item) {
        int index = this.index(item);
        this.items[index] = item;
        this.size++;
        return true;
    }

    private boolean add(T item, int index) {
        if(index < 0 || index >= this.size) {

        }
        return false;
    }


    public boolean remove(T item) {
        int index = this.index(item);
        return false;
    }

    public T get(int index) {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) this.items[index];
    }

    private int index(T item) {
        return this.index(item, 0);
    }

    private int index(T item, int currIndex) {
        if(currIndex == -1 || item.compareTo(this.get(currIndex)) > 0) {
            return -1;
        }
        if(this.items[currIndex].equals(item)) {
            return currIndex;
        }
        int index = this.index(item, this.left(currIndex));
        if(index != -1) {
            return index;
        }
        index = this.index(item, this.right(currIndex));
        return index;
    }

    private int rangeCheck(int index) {
        if(index > this.size) {
            return -1;
        }
        return index;
    }

    private int left(int i) {
        return this.rangeCheck(((i+1)*2) - 1);
    }

    private int right(int i) {
        return this.rangeCheck((i+1)*2);
    }

    private int parent(int i) {
        return this.rangeCheck((i-1)/2);
    }

}
