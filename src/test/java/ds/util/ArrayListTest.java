package ds.util;

import ds.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import ds.util.beans.Person;

public class ArrayListTest {

    public ArrayListTest() {}

    @Test
	public void testArrayList_Add() {
	    ArrayList<Integer> list = new ArrayList<>();
	    boolean added = list.add(5);
	    assertTrue(added);
	}

    @Test
	public void testArrayList_AddTwice() {
	    ArrayList<Integer> list = new ArrayList<>();
	    boolean added = list.add(5);
	    boolean addedSecond = list.add(5);
	    assertTrue(added);
	    assertTrue(addedSecond);
	}

    @Test
	public void testArrayList_AddTwiceContains() {
	    ArrayList<Person> list = new ArrayList<>();
	    boolean addedFirst = list.add(new Person(5));
	    boolean addedSecond = list.add(new Person(15));
	    boolean containsFirst = list.contains(new Person(5));
	    boolean containsSecond = list.contains(new Person(15));
	    assertTrue(addedFirst);
	    assertTrue(containsFirst);
	    assertTrue(addedSecond);
	    assertTrue(containsSecond);
	}

    @Test
	public void testArrayList_RemoveAdded() {
	    ArrayList<Person> list = new ArrayList<>();
	    boolean added = list.add(new Person(5));
	    assertEquals(1, list.size());
	    boolean removed = list.remove(new Person(5));
	    assertTrue(added);
	    assertTrue(removed);
	    assertEquals(0, list.size());
	}

    @Test
	public void testArrayList_SizeAddAndRemove() {
	    ArrayList<Person> list = new ArrayList<>();
	    list.add(new Person(5));
	    assertEquals(1, list.size());
	    list.add(new Person(15));
	    assertEquals(2, list.size());
	    list.remove(new Person(5));
	    assertEquals(1, list.size());
	    list.remove(new Person(15));
	    assertEquals(0, list.size());
	}


    @Test
	public void testArrayList_Resize() {
	    ArrayList<Person> list = new ArrayList<>(3);
	    Person p1 = new Person(1);
	    Person p2 = new Person(4);
	    Person p3 = new Person(15);
	    list.add(p1);
	    list.add(p2);
	    //this add should cause a resize
	    list.add(p3);
	    assertEquals(list.size(), 3);
	}

    @Test
	public void testArrayList_ResizeTwice() {
	    ArrayList<Integer> list = new ArrayList<>(3);
	    Integer p1 = new Integer(1);
	    Integer p2 = new Integer(4);
	    Integer p3 = new Integer(15);
	    Integer p4 = new Integer(20);
	    Integer p5 = new Integer(24);
	    list.add(p1);
	    list.add(p2);
	    //this add should cause a resize
	    list.add(p3);
	    //this add should cause a resize
	    list.add(p4);
	    list.add(p5);
	    assertEquals(list.size(), 5);
	}
}

