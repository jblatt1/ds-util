package ds.util;

import java.util.Collection;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;


@SuppressWarnings("unchecked")
public class HashSet<T> {

    private List<T>[] buckets;
    private int numBuckets;
    private static final int DEFAULT_NUM_BUCKETS = 100;

    public HashSet() {
	this(DEFAULT_NUM_BUCKETS);
    }

    public HashSet(int numBuckets) {
	this.numBuckets = numBuckets;
	this.buckets = new List[this.numBuckets];
    }

    private List<T> getBucket(T o) {
	int hash = o.hashCode();
	int bucketNum = hash%this.numBuckets;
	if(this.buckets[bucketNum] == null) {
	    this.buckets[bucketNum] = new LinkedList<>();
	}
	return this.buckets[bucketNum];
    } 

    public boolean add(T value) {
	if(!this.contains(value)) {
	    List<T> bucket = this.getBucket(value);
	    return bucket.add(value);
	}
	return false;
    }

    public boolean addAll(Collection<T> c) {
	for(T val: c) {
	    if(!this.contains(val)) {
		return false;
	    }
	}
	for(T val: c) {
	    this.add(val);
	}

	return true;
    }

    public void clear() {

    }

    public boolean contains(T value) {
	List<T> bucket = this.getBucket(value);
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
	return true;	
    }
    public Iterator<T> iterator() {
	return null;	
    }
    public boolean remove(T o) {
	List<T> bucket = this.getBucket(o);
	return bucket.remove(o);
    }

    public boolean removeAll(Collection<T> c) {
	for(T val: c) {
	    if(!this.remove(val)) {
		return false;
	    }
	}
	return true;
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
	return 0;
    }

    public Object[] toArray() {
	return new Object[this.size()];
    }

    public T[] toArray(T[] a) {
	return a;
    }
}

