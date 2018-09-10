package lec06;

public class Sort {

  public static void sort(int[] a) {
    for (int i = 1; i < a.length; i++) {
      int j;
      int index = a[i];
      for(j = i-1; j>=0 && a[j] > index; j--) {
        a[j+1] = a[j];
      }
      a[j+1] = index;
    }
  }

}
