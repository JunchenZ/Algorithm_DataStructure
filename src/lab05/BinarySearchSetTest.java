package lab05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchSetTest {

  BinarySearchSet<String> bss1, bss2;
  BinarySearchSet<Integer> bss3, bss4;
  Comparator<String> comparatorString;
  Comparator<Integer> comparatorDouble;
  ArrayList<String> arrayListString;
  ArrayList<Integer> arrayListInteger;

  @Before
  public void setUp() throws Exception {
    comparatorString = new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    };
    comparatorDouble = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    };

    // default constructor
    bss1 = new BinarySearchSet<String>();
    bss1.add("a");
    bss1.add("b");

    arrayListString = new ArrayList<String>();
    arrayListString.add("aa");
    arrayListString.add("bb");
    arrayListString.add("cc");
    arrayListString.add("dd");

    // constructor with parameter
    bss2 = new BinarySearchSet<String>(comparatorString);
    bss2.addAll(arrayListString);

    // default constructor
    bss3 = new BinarySearchSet<Integer>();
    bss3.add(1);
    bss3.add(2);

    arrayListInteger = new ArrayList<Integer>();
    arrayListInteger.add(10);
    arrayListInteger.add(20);
    arrayListInteger.add(30);
    arrayListInteger.add(40);

    // constructor with parameter
    bss4 = new BinarySearchSet<Integer>(comparatorDouble);
    bss4.addAll(arrayListInteger);
  }

  @Test
  public void testConstructor() {
    assertEquals(bss1.comparator(), null);
    assertEquals(bss2.comparator(), comparatorString);
    assertEquals(bss3.comparator(), null);
    assertEquals(bss4.comparator(), comparatorDouble);
  }

  @Test
  public void testFirst() {
    assertEquals(bss3.first(), (Integer) 1);
    assertEquals(bss4.first(), (Integer) 10);
  }

  @Test
  public void testLast() {
    assertEquals(bss3.last(), (Integer) 2);
    assertEquals(bss4.last(), (Integer) 40);
  }

  @Test
  public void testAdd() {
    assertTrue(bss1.add("c"));
    assertTrue(bss2.add("ee"));
    assertFalse(bss3.add(2));
    assertFalse(bss4.add(40));
  }

  @Test
  public void testAddAll() {
    assertTrue(bss1.addAll(arrayListString));
    assertFalse(bss1.addAll(arrayListString));
  }

  @Test
  public void testClear() {
    bss1.clear();
    bss2.clear();
    assertEquals(bss1.size(), 0);
    assertEquals(bss2.size(), 0);
  }

  @Test
  public void testContains() {
    assertFalse(bss1.contains("f"));
    assertFalse(bss2.contains("e"));
    assertTrue(bss3.contains(1));
    assertTrue(bss4.contains(10));
  }

  @Test
  public void testContainsAll() {
    bss1.clear();
    bss2.clear();
    assertFalse(bss1.containsAll(arrayListString));
    assertFalse(bss2.containsAll(arrayListString));
    assertFalse(bss3.containsAll(arrayListInteger));
    assertTrue(bss4.containsAll(arrayListInteger));
  }

  @Test
  public void testIsEmpty() {
    bss1.clear();
    bss2.clear();
    assertTrue(bss1.isEmpty());
    assertTrue(bss2.isEmpty());
    assertFalse(bss3.isEmpty());
    assertFalse(bss4.isEmpty());
  }

  @Test
  public void testIterator() {
    int i = 0;
    Integer j = 1;
    Iterator<Integer> iteratorBSS3 = bss3.iterator();
    while (iteratorBSS3.hasNext()) {
      assertEquals(iteratorBSS3.next(), j++);
    }
    Iterator<Integer> iteratorBSS4 = bss4.iterator();
    while (iteratorBSS4.hasNext()) {
      assertEquals(iteratorBSS4.next(), arrayListInteger.get(i++));
    }
  }

  @Test
  public void testRemove() {
    bss1.clear();
    bss2.clear();
    assertFalse(bss1.remove("g"));
    assertFalse(bss2.remove("hh"));
    bss1.add("g");
    bss2.add("hh");
    assertTrue(bss1.remove("g"));
    assertTrue(bss2.remove("hh"));
  }

  @Test
  public void testRemoveAll() {
    bss1.clear();
    bss2.clear();
    assertFalse(bss1.removeAll(arrayListString));
    assertFalse(bss2.removeAll(arrayListString));
    bss1.addAll(arrayListString);
    assertTrue(bss1.removeAll(arrayListString));
  }

  @Test
  public void testSize() {
    bss1.clear();
    bss2.clear();
    assertEquals(bss1.size(), 0);
    assertEquals(bss2.size(), 0);
  }

}
