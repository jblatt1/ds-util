package ds.util;

import ds.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import ds.util.beans.Person;

public class HashSetTest {

    public HashSetTest() {}

    @Test
	public void testHashSet_Add() {
	    HashSet<Integer> set = new HashSet<>();
	    boolean added = set.add(5);
	    assertTrue(added);
	}

    @Test
	public void testHashSet_AddTwice() {
	    HashSet<Integer> set = new HashSet<>();
	    boolean added = set.add(5);
	    boolean addedSecond = set.add(5);
	    assertTrue(added);
	    assertFalse(addedSecond);
	}

    @Test
	public void testHashSet_AddTwiceCollision() {
	    HashSet<Person> set = new HashSet<>();
	    boolean addedFirst = set.add(new Person(5));
	    boolean addedSecond = set.add(new Person(15));
	    boolean containsFirst = set.contains(new Person(5));
	    boolean containsSecond = set.contains(new Person(15));
	    assertTrue(addedFirst);
	    assertTrue(containsFirst);
	    assertTrue(addedSecond);
	    assertTrue(containsSecond);
	}

    @Test
	public void testHashSet_RemoveAdded() {
	    HashSet<Person> set = new HashSet<>();
	    boolean added = set.add(new Person(5));
	    assertEquals(1, set.size());
	    boolean removed = set.remove(new Person(5));
	    assertTrue(added);
	    assertTrue(removed);
	    assertEquals(0, set.size());
	}

    @Test
	public void testHashSet_RemoveGoodHashDidntAdd() {
	    HashSet<Person> set = new HashSet<>();
	    boolean removed = set.remove(new Person(5));
	    assertFalse(removed);
	    assertEquals(0, set.size());
	}


    @Test
	public void testHashSet_SizeAddAndRemove() {
	    HashSet<Person> set = new HashSet<>();
	    set.add(new Person(5));
	    assertEquals(1, set.size());
	    set.add(new Person(15));
	    assertEquals(2, set.size());
	    set.remove(new Person(5));
	    assertEquals(1, set.size());
	    set.remove(new Person(15));
	    assertEquals(0, set.size());
	}

    @Test
	public void testHashSet_RemoveHashCollision() {
	    HashSet<Person> set = new HashSet<>(1);
	    boolean addedFirst = set.add(new Person(5));
	    boolean addedSecond = set.add(new Person(15));
	    boolean removedFirst = set.remove(new Person(5));
	    boolean removedSecond = set.remove(new Person(15));
	    assertTrue(addedFirst);
	    assertTrue(removedFirst);
	    assertTrue(addedSecond);
	    assertTrue(removedSecond);
	    assertEquals(0, set.size());
	}

    @Test
	public void testHashSet_ToArray() {
	    HashSet<Person> set = new HashSet<>(10);
	    Person p = new Person(15);
	    set.add(p);
	    Object[] arr = set.toArray();
	    assertEquals(arr.length, 1);
	    assertTrue(set.contains(arr[0]));
	}


    @Test
	public void testHashSet_Resize() {
	    HashSet<Person> set = new HashSet<>(3);
	    Person p1 = new Person(1);
	    Person p2 = new Person(4);
	    Person p3 = new Person(15);
	    set.add(p1);
	    set.add(p2);
	    //this add should cause a resize
	    set.add(p3);
	    assertEquals(set.size(), 3);
	}

    @Test
	public void testHashSet_ResizeTwice() {
	    HashSet<Person> set = new HashSet<>(3);
	    Person p1 = new Person(1);
	    Person p2 = new Person(4);
	    Person p3 = new Person(15);
	    Person p4 = new Person(20);
	    Person p5 = new Person(24);
	    set.add(p1);
	    set.add(p2);
	    //this add should cause a resize
	    set.add(p3);
	    //this add should cause a resize
	    set.add(p4);
	    set.add(p5);
	    assertEquals(set.size(), 4);
	}
}

