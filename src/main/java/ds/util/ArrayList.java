package ds.util;

@SuppressWarnings("unchecked")
public class ArrayList<T> {
    private Object[] items;
    private int size;
    private int capacity;

    public ArrayList() {
	this(10);
    }

    private ArrayList(int capacity) {
	this.size = 0;
	this.grow(capacity); 
    }

    private void grow(int capacity) {
	this.capacity = capacity;
	Object[] items = this.items;
	this.items = new Object[this.capacity];
	for(int i=0; i<this.size; i++) {
	    this.add((T) items[i]);
	}
    }


    public boolean add(T t) {
	if(this.capacity <= this.size) {
	    this.grow(this.capacity * 2);
	}
	this.items[this.size++] = t;
	return true;
    }

    public T get(int i) throws IndexOutOfBoundsException {
	if(i >= this.size) {
	    throw new IndexOutOfBoundsException();
	}
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
	return item;
    }
	
}
