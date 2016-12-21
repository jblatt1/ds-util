package ds.util.heap;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import ds.util.beans.Person;
import ds.util.heap.Heap;

public class HeapTest {

    public HeapTest() {}

    @Test
	public void testHeap_Add() {
	    Heap<Integer> list = new Heap<>();
	    boolean added = list.add(5);
	    assertTrue(added);
	}

    @Test
	public void testHeap_AddTwice() {
	    Heap<Integer> list = new Heap<>();
	    boolean added = list.add(5);
	    boolean addedSecond = list.add(5);
	    assertTrue(added);
	    assertTrue(addedSecond);
	}

    @Test
	public void testHeap_HeapSort() {
        Integer[] unsortedItems = {23, 8, 35, 3};
        Integer[] expectedItems = {35, 23, 8, 3};
	    Heap<Integer> heap = new Heap<>();
        for(int i=0; i<unsortedItems.length; i++) {
            heap.add(unsortedItems[i]);
        }
        for(int i=0; i<expectedItems.length; i++) {
            assertEquals(expectedItems[i], heap.pop());
        }
	}
}

