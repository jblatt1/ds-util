package ds.util;

import ds.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import ds.util.beans.Person;
import ds.util.beans.PersonBadHash;

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
	    HashSet<PersonBadHash> set = new HashSet<>();
	    boolean addedFirst = set.add(new PersonBadHash(5));
	    boolean addedSecond = set.add(new PersonBadHash(15));
	    boolean containsFirst = set.contains(new PersonBadHash(5));
	    boolean containsSecond = set.contains(new PersonBadHash(15));
	    assertTrue(addedFirst);
	    assertTrue(containsFirst);
	    assertTrue(addedSecond);
	    assertTrue(containsSecond);
	}



    @Test
	public void testHashSet_RemoveGoodHash() {
	    HashSet<Person> set = new HashSet<>();
	    boolean added = set.add(new Person(5));
	    boolean removed = set.remove(new Person(5));
	    assertTrue(added);
	    assertTrue(removed);
	}

    @Test
	public void testHashSet_RemoveGoodHashDidntAdd() {
	    HashSet<Person> set = new HashSet<>();
	    boolean removed = set.remove(new Person(5));
	    assertFalse(removed);
	}

    @Test
	public void testHashSet_RemoveHashCollision() {
	    HashSet<PersonBadHash> set = new HashSet<>();
	    boolean addedFirst = set.add(new PersonBadHash(5));
	    boolean addedSecond = set.add(new PersonBadHash(15));
	    boolean removedFirst = set.remove(new PersonBadHash(5));
	    boolean removedSecond = set.remove(new PersonBadHash(15));
	    assertTrue(addedFirst);
	    assertTrue(removedFirst);
	    assertTrue(addedSecond);
	    assertTrue(removedSecond);
	}
}

