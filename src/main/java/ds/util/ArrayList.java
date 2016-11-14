package ds.util;

@SuppressWarnings("unchecked")
public class ArrayList<T> {
    private Object[] items;
    private int size;

    public ArrayList() {
	this(10);
    }

    public ArrayList(int size) {
	this.size = size;
	this.items = new Object[this.size]; 
    }

}
