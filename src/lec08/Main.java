package lec08;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    System.out.println(sumRecursive(100));
    System.out.println(sumFor(100));
    System.out.println(sum(100));
    System.out.println(divide(9, 2));
    System.out.println(times(9, 5));

    int[] arr = { 1, 3, 5, 7, 9 };

    if (binarySearch(arr, 5) && !binarySearch(arr, 6)) {
      System.out.println("Test passed");
    } else {
      System.out.println("Test failed");
    }

    if (binarySearchRecursion(arr, 5, 0, 4) && !binarySearchRecursion(arr, 6, 0, 4)) {
      System.out.println("Test passed");
    } else {
      System.out.println("Test failed");
    }

    if (binarySearchSimplifiedRecursion(arr, 5) && !binarySearchSimplifiedRecursion(arr, 6)) {
      System.out.println("Test passed");
    } else {
      System.out.println("Test failed");
    }

    int[] arr1 = { 1, 2, 3, 4, 5, 7, 8, 9, 10, 11 };
    int[] arr2 = { 1, 3, 5, 6, 7, 9, 11, 12 };
    int[] arrExpected = {1,2,3,4,5,6,7,8,9,10,11,12};
    int[] arrResult = merge(arr1, arr2);
    if(Arrays.equals(arrExpected, arrResult)){
      System.out.println("Test passed");
    } else {
      System.out.println("Test failed");
    }

  }

  public static int sumRecursive(int n) {
    if (n == 1) {
      return 1;
    }
    return n + sumRecursive(n - 1);
  }

  public static int sumFor(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += i;
    }
    return sum;
  }

  public static int sum(int n) {
    return n * (1 + n) / 2;
  }

  public static int divide(int a, int b) {
    if (a > b) {
      return 1 + divide(a - b, b);
    } else if (a == b) {
      return 1;
    } else
      return 0;
  }

  public static int times(int a, int b) {
    if (a > 1) {
      return b + times(a - 1, b);
    }
    return b;
  }

  public static boolean binarySearch(int[] arr, int item) {
    int low = 0, high = arr.length - 1;
    int mid = (low + high) / 2;

    while (low <= high) {
      if (item == arr[mid]) {
        return true;
      } else if (item > arr[mid]) {
        low = mid + 1;
        mid = (low + high) / 2;
      } else {
        high = mid - 1;
        mid = (low + high) / 2;
      }
    }
    return false;
  }

  public static boolean binarySearchRecursion(int[] arr, int item, int low, int high) {
    int mid = (low + high) / 2;

    if (arr[mid] == item) {
      return true;
    }

    if (low > high) {
      return false;
    }

    if (arr[mid] > item) {
      return binarySearchRecursion(arr, item, low, mid - 1);
    }

    return binarySearchRecursion(arr, item, mid + 1, high);
  }

  public static boolean binarySearchSimplifiedRecursion(int[] arr, int item) {
    int mid = (arr.length - 1) / 2;

    if (arr[mid] == item) {
      return true;
    }

    if (mid < 1) {
      return false;
    }

    int[] newArr = new int[mid];

    if (arr[mid] > item) {
      for (int i = 0; i <= mid - 1; i++) {
        newArr[i] = arr[i];
      }
      return binarySearchSimplifiedRecursion(newArr, item);
    }

    for (int i = mid + 1; i <= arr.length - 1; i++) {
      newArr[i - mid - 1] = arr[i];
    }

    return binarySearchSimplifiedRecursion(newArr, item);
  }

  public static int[] merge(int[] arr1, int[] arr2) {
    int repeat = 0;
    for (int item : arr1) {
      for (int i = 0; i < arr2.length; i++) {
        if (arr2[i] == item) {
          repeat++;
          break;
        }
      }
    }
    int[] newArr = new int[arr1.length + arr2.length - repeat];
    for (int i = 0, j = 0, k = 0; i < arr1.length || j < arr2.length; k++) {
      if(i < arr1.length && j < arr2.length) {
        if (arr1[i] < arr2[j]) {
          newArr[k] = arr1[i];
          i++;
        } else if (arr1[i] > arr2[j]) {
          newArr[k] = arr2[j];
          j++;
        } else {
          newArr[k] = arr2[j];
          i++;
          j++;
        }
      }else if(i == arr1.length) {
        newArr[k] = arr2[j];
        j++;
      }else {
        newArr[k] = arr1[i];
        i++;
      }
    }
    return newArr;

  }

}
