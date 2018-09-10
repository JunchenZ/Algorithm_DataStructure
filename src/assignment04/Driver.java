package assignment04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Driver<T> {

  private static int threshold = 10;

  public static void main(String[] args) {
    time();
  }

  /**
   * do the merge sort for a generic ArrayList
   * 
   * @param arrList
   * @param comparator
   */
  public static <T> void mergesort(ArrayList<T> arrList, Comparator<? super T> comparator) {
    ArrayList<T> newArrList = new ArrayList<T>(arrList);
    mergeSort(arrList, 0, arrList.size() - 1, comparator, newArrList);
    for (int i = 0; i < arrList.size(); i++) {
      arrList.set(i, newArrList.get(i));
    }
  }

  /**
   * called by the mergesort() method to do the merge sort for specific range of
   * the ArrayList if the size of sublist is less than threshold, do the insertion
   * sort instead
   * 
   * @param arrList:
   *          the original ArrayList
   * @param start
   *          : start point
   * @param end
   *          : end point
   * @param comparator
   * @param newArrList
   *          : same data as in arrList
   */
  public static <T> void mergeSort(ArrayList<T> arrList, int start, int end, Comparator<? super T> comparator,
      ArrayList<T> newArrList) {
    if ((end - start) < threshold) {
      insertionSort(arrList, start, end, comparator, newArrList);
      return;
    }
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(arrList, start, mid, comparator, newArrList);
      mergeSort(arrList, mid + 1, end, comparator, newArrList);
      merge(arrList, start, mid, end, comparator, newArrList);
    }
  }

  /**
   * called by the mergeSort() method, merge part of the ArrayList by dividing it
   * into two halves
   * 
   * @param arrList:
   *          the original ArrayList
   * @param start:
   *          start point
   * @param mid:
   *          the mid position
   * @param end:
   *          the end point
   * @param comparator
   * @param newArrList:
   *          same data as in arrList
   */
  public static <T> void merge(ArrayList<T> arrList, int start, int mid, int end, Comparator<? super T> comparator,
      ArrayList<T> newArrList) {
    int index = start;
    int i = start, j = mid + 1;
    while (i <= mid && j <= end) {
      if (comparator.compare(arrList.get(i), arrList.get(j)) > 0) {
        newArrList.set(index++, arrList.get(j++));
      } else {
        newArrList.set(index++, arrList.get(i++));
      }
    }
    while (i <= mid) {
      newArrList.set(index++, arrList.get(i++));
    }
    while (j <= end) {
      newArrList.set(index++, arrList.get(j++));
    }
    for (int k = start; k <= end; k++) {
      arrList.set(k, newArrList.get(k));
    }
  }

  /**
   * the insertion sort is called when the size of sublist is less than threshold
   * 
   * @param arrList:
   *          the original ArrayList
   * @param start:
   *          the start point
   * @param end:
   *          the end point
   * @param comparator
   * @param newArrList:
   *          same data as in the original ArrayList
   */
  public static <T> void insertionSort(ArrayList<T> arrList, int start, int end, Comparator<? super T> comparator,
      ArrayList<T> newArrList) {
    for (int i = start + 1; i <= end; i++) {
      T temp = arrList.get(i);
      for (int j = i - 1; j >= start; j--) {
        if (comparator.compare(temp, arrList.get(j)) < 0) {
          arrList.set(j + 1, arrList.get(j));
          if (j == start) {
            arrList.set(start, temp);
          }
        } else {
          arrList.set(j + 1, temp);
          break;
        }
      }
    }
    for (int i = start; i <= end; i++) {
      newArrList.set(i, arrList.get(i));
    }
  }

  /**
   * generate an ArrayList in ascending order
   * 
   * @param size
   * @return
   */
  public static ArrayList<Integer> generateBestCase(int size) {
    ArrayList<Integer> arrList = new ArrayList<Integer>(size);
    for (int i = 0; i < size; i++) {
      arrList.add(i);
    }
    return arrList;
  }

  /**
   * generate an permuted ArrayList
   * 
   * @param size
   * @return
   */
  public static ArrayList<Integer> generateAverageCase(int size) {
    Random rand = new Random();
    ArrayList<Integer> arrList = new ArrayList<Integer>(size);
    for (int i = 0; i < size; i++) {
      arrList.add(i);
    }
    for (int i = 0; i < size; i++) {
      int temp = arrList.get(i);
      int index = rand.nextInt(size);
      arrList.set(i, arrList.get(index));
      arrList.set(index, temp);
    }
    return arrList;
  }

  /**
   * generate an ArrayList in descending order
   * 
   * @param size
   * @return
   */
  public static ArrayList<Integer> generateWorstCase(int size) {
    ArrayList<Integer> arrList = new ArrayList<Integer>(size);
    for (int i = size - 1; i >= 0; i--) {
      arrList.add(i);
    }
    return arrList;
  }

  /**
   * test the time for different threshold
   * 
   */
  public static void time() {
    long startTime = System.nanoTime();
    while (System.nanoTime() - startTime < 1000_000_000)
      ;

    for (int size = 5000; size <= 25000; size += 1000) {

      ArrayList<Integer> arrList = generateWorstCase(size);
      long totalTime = 0;

      for (int i = 0; i < 100; i++) {

        ArrayList<Integer> newArrList = new ArrayList<Integer>(arrList);
        long start = System.nanoTime();

        mergesort(newArrList, new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
          }
        });

        long stop = System.nanoTime();
        totalTime += stop - start;
      }
      double averageTime = totalTime / 100;
      System.out.println(size + "\t" + averageTime);
    }
  }
  
  /**
   * Sorts an ArrayList as specified by the Comparator argument. As denoted by
   * the nomenclature, this method implements recursive calls to merge sort and
   * should, in most cases, demonstrate linearithmic behavior.
   * 
   * @param arrayList
   *          the ArrayList to be sorted
   * @param comparator
   *          the Comparator to determine how to sort arrayList
   */
  public static <T> void quicksort(ArrayList<T> arrayList,
      Comparator<T> comparator) {
    quicksort(arrayList, 0, arrayList.size() - 1, comparator);
  }
  
  /**
   * Implements the quicksort algorithm. The internal comparisons are governed
   * by the Comparator argument (see the public quicksort Driver method for
   * additional documentation).
   * 
   * Sorts the entire ArrayList, from index 0 to index size - 1.
   * 
   * @param arrayList
   *          the ArrayList to be sorted
   * @param leftIndex
   *          the left-most bound of arrayList
   * @param rightIndex
   *          the right-most bound of arrayList
   * @param comparator
   *          the Comparator to determine how to sort arrayList
   */
  private static <T> void quicksort(ArrayList<T> arrayList, int leftIndex,
      int rightIndex, Comparator<T> c) {
    // ArrayLists containing less than 2 elements are already sorted
    if (leftIndex >= rightIndex) {
      return;
    }
    // Split the ArrayList at the pivot and recursively sort each subarray
    int pivotIndex = partition(arrayList, leftIndex, rightIndex, c);
    quicksort(arrayList, leftIndex, pivotIndex - 1, c);
    quicksort(arrayList, pivotIndex + 1, rightIndex, c);
  }
  
  /**
   * Determines the correct location for each pivot element and returns the
   * correct location of the pivot for the given method iteration. Thus, when
   * this method returns, all elements to the left of the pivot are less than
   * the pivot and all elements to the right of the pivot are greater than the
   * pivot.
   * 
   * @param arrayList
   *          the arrayList to be sorted
   * @param leftIndex
   *          the left-most bound of this subarray
   * @param rightIndex
   *          the right-most bound of this subarray
   * @param comparator
   *          the Comparator to determine how to sort arrayList
   * @return the index of the pivot in its correct (sorted) location
   */
  private static <T> int partition(ArrayList<T> arrayList, int leftIndex,
      int rightIndex, Comparator<? super T> comparator) {
    // When the pivot is initialized, it will have already been moved to the end
    // of the ArrayList (see the getPivot method)
    T pivot = getPivot(arrayList, leftIndex, rightIndex, comparator);
    
    /*
     * -------------------------------------------------------------------------
     * The following methods are used when executing quicksort runtime analysis:
     * 
     * T pivot = AlternatePivotMethods.getPivotAlternateMiddle(arrayList,
     * leftIndex, rightIndex, comparator); T pivot =
     * AlternatePivotMethods.getPivotAlternateRandomMedian(arrayList, leftIndex,
     * rightIndex, comparator);
     * -------------------------------------------------------------------------
     */
    
    // The right pointer starts at one less than the end of the array to
    // account for the pivot
    int leftPointer = leftIndex;
    int rightPointer = rightIndex - 1;
    
    // Swap pairs which are found on the wrong side of the intended correct
    // pivot location, and ultimately, swap the pivot to that location
    while (leftPointer <= rightPointer) {
      // Explicitly declare these variables for enhanced readability
      T left = arrayList.get(leftPointer);
      T right = arrayList.get(rightPointer);
      
      if (comparator.compare(left, pivot) <= 0) {
        // Value belongs on left-side of pivot and is on the correct side
        leftPointer++;
        continue;
      }
      if (comparator.compare(pivot, right) <= 0) {
        // Value belongs on right-side of pivot and is on the correct side
        rightPointer--;
        continue;
      }
      // Values need to be swapped to the either side of the correct pivot
      // location
      swap(arrayList, leftPointer, rightPointer);
      leftPointer++;
      rightPointer--;
    }
    // When the left and right pointer meet, this is the correct location for
    // the pivot element. Swap the pivot element to this index
    swap(arrayList, leftPointer, rightIndex);
    
    // Return the partition index (determines the next round of subarrays)
    return leftPointer;
  }
  
  /**
   * Swap the two elements at the provided indices.
   * 
   * @param arrayList
   *          the ArrayList to be sorted
   * @param leftIndex
   *          index to be swapped
   * @param rightIndex
   *          index to be swapped
   */
  private static <T> void swap(ArrayList<T> arrayList, int leftIndex,
      int rightIndex) {
    T temp = arrayList.get(rightIndex);
    arrayList.set(rightIndex, arrayList.get(leftIndex));
    arrayList.set(leftIndex, temp);
  }
  
  /**
   * Determines the pivot element via the median-of-three. Orders the first,
   * middle, and last element in the ArrayList without sorting arrayList and
   * without creating a new ArrayList. Returns the median of the three.
   * 
   * This method estimates the returned value to be approximately at the
   * midpoint of the array.
   * 
   * IMPORTANT: This method swaps the position of the pivot to the end of the
   * ArrayList before returning.
   * 
   * @param arrayList
   *          the ArrayList to be sorted
   * @param leftIndex
   *          the left-most bound of this subarray
   * @param rightIndex
   *          the right-most bound of this subarray
   * @param comparator
   *          the Comparator to determine how to sort arrayList
   * @return the pivot element
   */
  private static <T> T getPivot(ArrayList<T> arrayList, int leftIndex,
      int rightIndex, Comparator<? super T> comparator) {
    
    // Store elements for subsequent comparisons in order to find the median
    T first = arrayList.get(leftIndex);
    T middle = arrayList.get((leftIndex + rightIndex) / 2);
    T last = arrayList.get(rightIndex);
    
    int medianIndex = 0;
    
    // Find the median of the three elements without sorting or creating a new
    // ArrayList
    if (comparator.compare(first, middle) >= 0
        && comparator.compare(first, last) <= 0) {
      medianIndex = leftIndex;
    } else if (comparator.compare(middle, first) >= 0
        && comparator.compare(middle, last) <= 0) {
      medianIndex = (leftIndex + rightIndex) / 2;
    } else {
      medianIndex = rightIndex;
    }
    
    // Swap pivot to end of the array
    swap(arrayList, medianIndex, rightIndex);
    
    // Return pivot element
    return arrayList.get(rightIndex);
  }

}
