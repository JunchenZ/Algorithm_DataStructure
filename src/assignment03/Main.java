package assignment03;

import java.util.Random;

public class Main {

  private static final int ITER_COUNT = 100;

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    while (System.nanoTime() - startTime < 1_000_000_000);
    
    Random random = new Random();
    for (int exp = 8; exp <= 20; exp++) { // This is used as the exponent to calculate the size of the set.
      int size = (int) Math.pow(2, exp);

      // Do the experiment multiple times, and average out the results
      long totalTime = 0;

      // SET UP!
      for (int iter = 0; iter < ITER_COUNT; iter++) {
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
          int length = random.nextInt(15) + 1;
          String str = "";
          for(int j = 0; j<length; j++) {
            str += Integer.toString(random.nextInt(26 + 'a'));
          }
          arr[i] = str;
        }
        // TIME IT!
        long start = System.nanoTime();
        AnagramUtil.getLargestAnagramGroup(arr);
        long stop = System.nanoTime();
        totalTime += stop - start;
      }

      double averageTime = totalTime / (double) ITER_COUNT;
      System.out.println(size + "\t" + averageTime); // print to console
    }

  }

}
