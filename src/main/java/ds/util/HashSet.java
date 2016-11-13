package ds.util;

import java.util.Collection;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class HashSet<T> {

    private List<T>[] buckets;
    private int numBuckets;
    private int size;
    private static final int DEFAULT_NUM_BUCKETS = 100;

    public HashSet() {
	this(DEFAULT_NUM_BUCKETS);
    }

    public HashSet(int numBuckets) {
	this.numBuckets = numBuckets;
	this.buckets = new List[this.numBuckets];
	this.size = 0;
    }

    private void resize() {
	Object[] items = this.toArray();
	this.numBuckets *= 2;
	this.buckets = new List[this.numBuckets];
	for(Object o: items) {
	    this.add((T) o);
	}
    }

    private int indexOf(T o) {
	int hash = o.hashCode();
	return hash%this.numBuckets;
    }

    private List<T> getBucket(T o) {
	int bucketNum = this.indexOf(o);
	if(this.buckets[bucketNum] == null) {
	    this.buckets[bucketNum] = new LinkedList<>();
	}
	return this.buckets[bucketNum];
    } 

    public boolean add(T value) {
	if(!this.contains(value)) {
	    List<T> bucket = this.getBucket(value);
	    boolean added = bucket.add(value);
	    if(added) {
		this.size++;
	    }
	    return added;
	}
	if (this.size()/2 >= this.numBuckets) {
	    // half full, so resize to avoid collisions
	    this.resize();
	}
	return false;
    }

    public boolean addAll(Collection<T> c) {
	for(T val: c) {
	    this.add(val);
	}
	return true;
    }

    public void clear() {
	//TODO: use iterator to do this
	Interator i = this.iterator();
	while(i.hasNext()) {
	    i.remove();
	    i.next();
	}
    }

    public boolean contains(Object value) {
	List<T> bucket = this.getBucket((T) value);
	for(T o: bucket) {
	    if(o.equals(value)) {
		return true;
	    }
	}
	return false;
    }

    public boolean containsAll(Collection<T> c) {
	for(T val: c) {
	    if(!this.contains(val)) {
		return false;
	    }
	}
	return true;
    }

    public boolean isEmpty() {
	return this.size == 0;
    }

    public Iterator<T> iterator() {
	return new HashIterator();	
    }

    public boolean remove(T o) {
	List<T> bucket = this.getBucket(o);
	boolean removed = bucket.remove(o);
	if(removed) {
	    this.size--;
	}
	return removed;
    }

    public boolean removeAll(Collection<T> c) {
	boolean changed = false;
	for(T val: c) {
	    changed = changed || this.remove(val);
	}
	return changed;
    }

    public boolean retainAll(Collection<T> c) {
	for(T val: c) {
	    if(!this.remove(val)) {
		return false;
	    }
	}
	return true;
    }
    public int size() {
	return this.size;
    }

    public Object[] toArray() {
	Iterator it = this.iterator();
	Object[] retVal = new Object[this.size()];
	for(int i=0; i < this.size() && it.hasNext(); i++) {
	    retVal[i] = it.next();
	}
	return retVal; 
    }

    public T[] toArray(T[] a) {
	//TODO: use iterator
	return a;
    }

    private class HashIterator implements Iterator {
	private List<T>[] entries;
	private Entry curr;

	public HashIterator() {
	    this.entries = buckets;
	    this.curr = new Entry(0, 0);
	}

	private List<T> getBucket(int bucketNum) {
	    if(bucketNum < entries.length) {
		return this.entries[bucketNum];
	    }
	    return null;
	}

	private Entry getNext(Entry o) {
	    Entry c = new Entry(o);
	    if(c.currBucket >= this.entries.length) {
		return c;
	    }
	    List<T> bucket = this.getBucket(c.currBucket);
	    if(bucket == null || c.currIndex >= bucket.size()) {
		return this.getNext(new Entry(c.currBucket+1, 0));
	    } else {
		c.element = bucket.get(c.currIndex);
		return c;
	    }
	}

	private class Entry {
	    public int currBucket;
	    public int currIndex;
	    public T element;

	    public Entry () {
		this(0);
	    }
	    public Entry(int currBucket) {
		this(currBucket, 0);
	    }
	    public Entry(int currBucket, int currIndex) {
		this.currBucket = currBucket;
		this.currIndex = currIndex;
	    }
	    public Entry(Entry c) {
		this(c.currBucket, c.currIndex); 
	    }
	}

	public boolean hasNext() {
	    Entry next = this.getNext(this.curr);
	    return next.element != null;
	}

	public T next() {
	    Entry next = this.getNext(this.curr);
	    this.curr = next;
	    return next.element;
	}

	public void remove() {

	}
    }
}

