package lab07;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {

  private DoublyLinkedList<Integer> dll1;
  
  @Before
  public void setUp() throws Exception {
    dll1 = new DoublyLinkedList<Integer>();
  }

  @Test
  public void testAddFirst() {
    dll1.addFirst(1);
    assertEquals((Integer)1, dll1.getFirst());
    assertEquals((Integer)1, dll1.getLast()); 
    dll1.addFirst(0);
    assertEquals((Integer)0, dll1.getFirst());
    assertEquals((Integer)1, dll1.getLast());
  }
  
  @Test
  public void testAddLast() {
    dll1.clear();
    dll1.addLast(1);
    assertEquals((Integer)1, dll1.getFirst());
    assertEquals((Integer)1, dll1.getLast());
    dll1.addLast(0);
    assertEquals((Integer)1, dll1.getFirst());
    assertEquals((Integer)0, dll1.getLast());
  }
  
  @Test
  public void testAdd() {
    dll1.clear();
    dll1.add(0, 0);
    assertEquals((Integer)0, dll1.getFirst());
    assertEquals((Integer)0, dll1.getLast());
    dll1.add(0, 1);
    assertEquals((Integer)1, dll1.getFirst());
    assertEquals((Integer)0, dll1.getLast());
  }
  
  @Test
  public void testGet() {
    dll1.clear();
    dll1.add(0, 0);
    assertEquals((Integer)0, dll1.get(0));
    dll1.add(0, 1);
    assertEquals((Integer)1, dll1.get(0));
    assertEquals((Integer)0, dll1.get(1));
  }
  
  @Test
  public void testRemoveFirst() {
    dll1.clear();
    dll1.add(0, 0);
    dll1.add(0, 1);
    assertEquals((Integer)1, dll1.getFirst());
    assertEquals((Integer)1, dll1.removeFirst());
    assertEquals((Integer)0, dll1.getFirst());
  }
  
  @Test
  public void testRemoveLast() {
    dll1.clear();
    dll1.add(0, 0);
    dll1.add(0, 1);
    assertEquals((Integer)0, dll1.getLast());
    assertEquals((Integer)0, dll1.removeLast());
    assertEquals((Integer)1, dll1.getLast());
  }
  
  @Test
  public void testRemove() {
    dll1.clear();
    dll1.add(0, 0);
    dll1.add(0, 1);
    assertEquals((Integer)0, dll1.remove(1));
    assertEquals((Integer)1, dll1.remove(0));
  }
  
  @Test
  public void testIndexOf() {
    dll1.clear();
    dll1.add(0, 0);
    dll1.add(0, 1);
    dll1.add(0, 1);
    assertEquals(0, dll1.indexOf(1));
    assertEquals(2, dll1.indexOf(0));
  }
  
  @Test
  public void testLastIndexOf() {
    dll1.clear();
    dll1.add(0, 0);
    dll1.add(0, 1);
    dll1.add(0, 1);
    assertEquals(1, dll1.lastIndexOf(1));
    assertEquals(2, dll1.lastIndexOf(0));
  }
  
  @Test
  public void testIsEmpty() {
    dll1.clear();
    assertTrue(dll1.isEmpty());
    dll1.add(0, 0);
    assertFalse(dll1.isEmpty());
  }
  
  @Test
  public void testToArray() {
    dll1.clear();
    dll1.add(0, 0);
    dll1.add(0, 1);
    dll1.add(0, 2);
    assertArrayEquals(new Object[] {2, 1, 0}, dll1.toArray());
  }

}
