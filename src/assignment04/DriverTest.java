package assignment04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {

  private ArrayList<Integer> arrListBest, arrListWorst, arrListInsertion1, arrListInsertion2, arrListInsertion3,
      arrListMerge1, arrListMerge2, arrListMerge3, arrListQuick1, arrListQuick2, arrListQuick3;

  @Before
  public void setUp() throws Exception {

    arrListBest = new ArrayList<Integer>(5000);
    for (int i = 0; i < 5000; i++) {
      arrListBest.add(i);
    }

    arrListWorst = new ArrayList<Integer>(5000);
    for (int i = 4999; i >= 0; i--) {
      arrListWorst.add(i);
    }

    arrListInsertion1 = Driver.generateAverageCase(5000);
    Driver.insertionSort(arrListInsertion1, 0, 4999, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    }, new ArrayList<Integer>(arrListInsertion1));

    arrListInsertion2 = Driver.generateWorstCase(5000);
    Driver.insertionSort(arrListInsertion2, 0, 4999, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    }, new ArrayList<Integer>(arrListInsertion2));

    arrListInsertion3 = Driver.generateAverageCase(5000);
    Driver.insertionSort(arrListInsertion3, 0, 4999, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    }, new ArrayList<Integer>(arrListInsertion3));

    arrListMerge1 = Driver.generateAverageCase(5000);
    Driver.mergesort(arrListMerge1, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    });

    arrListMerge2 = Driver.generateAverageCase(5000);
    Driver.mergesort(arrListMerge2, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    });

    arrListMerge3 = Driver.generateAverageCase(5000);
    Driver.mergesort(arrListMerge3, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    });

    arrListQuick1 = Driver.generateAverageCase(5000);
    Driver.quicksort(arrListQuick1, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    });

    arrListQuick2 = Driver.generateAverageCase(5000);
    Driver.quicksort(arrListQuick2, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    });

    arrListQuick3 = Driver.generateAverageCase(5000);
    Driver.quicksort(arrListQuick3, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    });

  }

  @Test
  public void testGenerateBestCase() {
    assertEquals(arrListBest, Driver.generateBestCase(5000));
  }

  @Test
  public void testGenerateAverageCase() {
    assertTrue(Driver.generateAverageCase(5000).containsAll(arrListBest));
  }

  @Test
  public void testGenrateWorstCase() {
    assertEquals(arrListWorst, Driver.generateWorstCase(5000));
  }

  @Test
  public void testInsertionSort() {
    assertEquals(Driver.generateBestCase(5000), arrListInsertion1);
    assertEquals(Driver.generateBestCase(5000), arrListInsertion2);
    assertEquals(Driver.generateBestCase(5000), arrListInsertion3);
  }

  @Test
  public void testMergeSort() {
    assertEquals(Driver.generateBestCase(5000), arrListMerge1);
    assertEquals(Driver.generateBestCase(5000), arrListMerge2);
    assertEquals(Driver.generateBestCase(5000), arrListMerge3);
  }

  @Test
  public void testQuickSort() {
    assertEquals(Driver.generateBestCase(5000), arrListQuick1);
    assertEquals(Driver.generateBestCase(5000), arrListQuick2);
    assertEquals(Driver.generateBestCase(5000), arrListQuick3);
  }

}
