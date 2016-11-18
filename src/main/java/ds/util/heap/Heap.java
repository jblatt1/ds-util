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

    public boolean remove(T item) {
	Integer index = this.index(item);
	return false;
    }

    public T get(Integer index) {
	if(index < this.size) {
	    return (T) this.items[index];
	}
	throw new IndexOutOfBoundsException();
    }

    private Integer index(T item) {
	return this.index(item, 0);
    }
    
    private Integer index(T item, Integer currIndex) {
	if(currIndex == null || item.compareTo(this.get(currIndex)) > 0) {
	    return null;
	}
	if(this.items[currIndex].equals(item)) {
	    return currIndex;
	}
	Integer index = this.index(item, this.left(currIndex));
	if(index != null) {
	    return index;
	}
	index = this.index(item, this.right(currIndex));
	return index;
    }

    private Integer rangeCheck(int index) {
	if(index > this.size) {
	    return null;
	}
	return index;
    }

    private Integer left(int i) {
	return this.rangeCheck(((i+1)*2) - 1);
    }

    private Integer right(int i) {
	return this.rangeCheck((i+1)*2);
    }

    private Integer parent(int i) {
	return this.rangeCheck((i-1)/2);
    }

}
