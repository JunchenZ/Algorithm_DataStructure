package assignment07;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ChainingHashTableTest {

  private ChainingHashTable cht1;
  private ArrayList<String> al1, al2;
  
  @Before
  public void setUp() throws Exception {
    cht1 = new ChainingHashTable(19, new BadHashFunctor());
    al1 = new ArrayList<String>();
    al2 = new ArrayList<String>();
    al1.add("a");
    al1.add("b");
    al2.add("b");
    al2.add("c");
  }

  @Test
  public void testAdd() {
    cht1.clear();
    assertEquals(0, cht1.size());
    assertTrue(cht1.add("a"));
    assertTrue(cht1.contains("a"));
    assertEquals(1, cht1.size());
    assertFalse(cht1.add("a"));
    assertEquals(1, cht1.size());
    assertTrue(cht1.contains("a"));
    assertTrue(cht1.add("b"));
    assertEquals(2, cht1.size());
    assertTrue(cht1.contains("a"));
    assertTrue(cht1.contains("b"));
  }
  
  @Test
  public void testAddAll() {
    cht1.clear();
    assertEquals(0, cht1.size());
    assertTrue(cht1.addAll(al1));
    assertTrue(cht1.contains("a"));
    assertTrue(cht1.contains("b"));
    assertEquals(2, cht1.size());
    assertFalse(cht1.addAll(al1));
    assertEquals(2, cht1.size()); 
    assertTrue(cht1.addAll(al2));
    assertTrue(cht1.contains("c"));
    assertEquals(3, cht1.size()); 
  }
  
  @Test
  public void testClear() {
    cht1.clear();
    assertEquals(0, cht1.size());
    cht1.add("a");
    assertTrue(cht1.contains("a"));
    assertEquals(1, cht1.size());
    cht1.clear();
    assertFalse(cht1.contains("a"));
    assertEquals(0, cht1.size());
  }
  
  @Test
  public void testContains() {
    cht1.clear();
    assertFalse(cht1.contains("a"));
    cht1.add("a");
    assertTrue(cht1.contains("a"));
  }
  
  @Test
  public void testContainsAll() {
    cht1.clear();
    assertFalse(cht1.containsAll(al1));
    cht1.addAll(al1);
    assertTrue(cht1.containsAll(al1));
  }
  
  @Test
  public void testIsEmpty() {
    cht1.clear();
    assertTrue(cht1.isEmpty());
    assertEquals(0, cht1.size());
    cht1.add("a");
    assertFalse(cht1.isEmpty());
    assertEquals(1, cht1.size());
  }
  
  @Test
  public void testRemove() {
    cht1.clear();
    assertEquals(0, cht1.size());
    assertFalse(cht1.remove("a"));
    cht1.add("a");
    assertEquals(1, cht1.size());
    assertTrue(cht1.remove("a"));
    assertEquals(0, cht1.size());
  }
  
  @Test
  public void testRemoveAll() {
    cht1.clear();
    assertFalse(cht1.removeAll(al1));
    cht1.addAll(al1);
    assertEquals(2, cht1.size());
    assertTrue(cht1.removeAll(al1));
    assertEquals(0, cht1.size());
  }
  
  @Test
  public void testSize() {
    cht1.clear();
    assertEquals(0, cht1.size());
    cht1.add("a");
    assertEquals(1, cht1.size());
    cht1.remove("a");
    assertEquals(0, cht1.size());
  }

}
