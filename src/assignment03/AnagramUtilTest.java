package assignment03;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class AnagramUtilTest {

  private String[] strArr1, strArr2, strArr3, strArr4, strArr5;
  private Integer[] intArr1, intArr2;
  
  @Before
  public void setUp() throws Exception {
    strArr1 = new String[] {"zyx", "wvu", "tsr"};
    strArr2 = new String[] {"tsr", "wvu", "zyx"};
    intArr1 = new Integer[] {2, 4, 5, 1, 3};
    intArr2 = new Integer[] {1, 2, 3, 4, 5};
    strArr3 = new String[] {"acb", "gd", "cba", "xa", "dg", "dg"};
    strArr4 = new String[] {"dg", "dg", "gd"};
    strArr5 = new String[] {"carets", "Caters", "caster", "crates", "Reacts", "recast", "traces"};
  }

  @Test
  public void testSort() {
    assertEquals("ehllo", AnagramUtil.sort("Hello"));
    assertEquals("dlorw", AnagramUtil.sort("world"));
  }
  
  @Test
  public void testInsertionSort() {
    AnagramUtil.insertionSort(intArr1, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }      
    });
    assertArrayEquals(intArr2, intArr1);
    
    AnagramUtil.insertionSort(strArr1, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }      
    });
    assertArrayEquals(strArr2, strArr1);
  }
  
  @Test
  public void testAreAnagrams() {
    assertTrue(AnagramUtil.areAnagrams("ehllo", "Hello"));
    assertFalse(AnagramUtil.areAnagrams("world", "worid"));
  }
  
  @Test
  public void testGetLargestAnagramGroup() {
    String[] strArrNew = AnagramUtil.getLargestAnagramGroup(strArr3);
    AnagramUtil.insertionSort(strArrNew, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }      
    });
    AnagramUtil.insertionSort(strArr4, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }      
    });
    assertArrayEquals(strArr4, strArrNew);
  }

  @Test
  public void testFile() throws FileNotFoundException {
    String[] strArrNew = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
    AnagramUtil.insertionSort(strArrNew, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }      
    });
    AnagramUtil.insertionSort(strArr5, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }      
    });
    assertArrayEquals(strArr5, strArrNew);
  }
}
