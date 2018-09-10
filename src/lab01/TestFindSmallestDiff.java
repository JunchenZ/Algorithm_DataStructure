package lab01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFindSmallestDiff {

  private int[] arr1, arr2, arr3, arr4;
  
  @Before
  public void setUp() throws Exception {
//    super.setUp();
      
    arr1 = new int[0];
    arr2 = new int[] { 3, 3, 3 };
    arr3 = new int[] { 52, 4, -8, 0, -17 };
    arr4 = new int[] { 324, 65, 34, Integer.MAX_VALUE, -10, -Integer.MAX_VALUE};
  }

  @After
  public void tearDown() throws Exception {
  }

//  @Test
//  public void test() {
//    fail("Not yet implemented");
//  }
  
  @Test
  public void emptyArray() {
    assertEquals(-1, DiffUtil.findSmallestDiff(arr1));
  }
  
  @Test
  public void allArrayElementsEqual() {
    assertEquals(0, DiffUtil.findSmallestDiff(arr2));
  }

  @Test
  public void smallRandomArrayElements() {
    assertEquals(4, DiffUtil.findSmallestDiff(arr3));
  }
  
  @Test
  public void maxValueElement() {
    assertEquals(31, DiffUtil.findSmallestDiff(arr4));
  }

}
