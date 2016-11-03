package ds.util;

import ds.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

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
}

