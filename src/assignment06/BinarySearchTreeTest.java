package assignment06;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

  BinarySearchTree<Integer> bst;
  ArrayList<Integer> al, alSorted;
  
  @Before
  public void setUp() throws Exception {
    bst = new BinarySearchTree<Integer>();
    al = new ArrayList<Integer>();
    for(int i : new int[] {7, 4, 11}) {
      al.add(i);
    }
    alSorted = new ArrayList<Integer>();
    for(int i : new int[] {4, 7, 11}) {
      alSorted.add(i);
    }
  }

  @Test
  public void testAdd() {
    assertTrue(bst.add(7));
    assertFalse(bst.add(7));
  }
  
  @Test
  public void testAddAll() {
    bst.clear();
    assertTrue(bst.addAll(al));
    assertFalse(bst.addAll(al));
  }
  
  @Test
  public void testContains() {
    bst.clear();
    assertFalse(bst.contains(7));
    bst.add(7);
    assertTrue(bst.contains(7));
  }
  
  @Test
  public void testContainsAll() {
    bst.clear();
    assertFalse(bst.containsAll(al));
    bst.addAll(al);
    assertTrue(bst.containsAll(al));
  }
  
  @Test
  public void testFirst() {
    bst.clear();
    bst.add(7);
    assertEquals((Integer)7, bst.first());
    bst.addAll(al);
    assertEquals((Integer)4, bst.first());
  }
  
  @Test
  public void testIsEmpty() {
    bst.clear();
    assertTrue(bst.isEmpty());
    bst.add(7);
    assertFalse(bst.isEmpty());
  }
  
  @Test
  public void testLast() {
    bst.clear();
    bst.add(7);
    assertEquals((Integer)7, bst.last());
    bst.addAll(al);
    assertEquals((Integer)11, bst.last());
  }
  
  @Test
  public void testRemove() {
    bst.clear();
    assertFalse(bst.remove(7));
    bst.add(7);
    assertTrue(bst.remove(7));
  }
  
  @Test
  public void testRemoveAll() {
    bst.clear();
    assertFalse(bst.removeAll(al));
    bst.add(7);
    assertTrue(bst.removeAll(al));
  }
  
  @Test
  public void testToArrayList() {
    bst.clear();
    bst.addAll(al);
    assertTrue(alSorted.equals(bst.toArrayList()));
  }
  
}
