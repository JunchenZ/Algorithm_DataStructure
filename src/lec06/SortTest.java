package lec06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortTest {

  private int[] arr1, arr2, sorted1, sorted2;

  @Before
  public void setUp() throws Exception {
    arr1 = new int[] { -1, 5, 7, 3, 94, 34, 32, 65 };
    sorted1 = new int[] { -1, 3, 5, 7, 32, 34, 65, 94 };
    arr2 = new int[] { 23, 65, 36, 76, 42, 46, -2, 46 };
    sorted2 = new int[] { -2, 23, 36, 42, 46, 46, 65, 76 };
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() {
    Sort.sort(arr1);
    for(int i = 0; i < arr1.length; i++) {
      System.out.println(arr1[i]);
    }
    assertArrayEquals(sorted1, arr1);
    Sort.sort(arr2);
    assertArrayEquals(sorted2, arr2);
  }

}
