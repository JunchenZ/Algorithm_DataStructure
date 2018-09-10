package lab05;

import java.util.Comparator;
import java.util.Random;

public class Main {

  private static final int ITER_COUNT = 100;

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    while (System.nanoTime() - startTime < 1_000_000_000)
      ;

    Random random = new Random();
    for (int exp = 8; exp <= 20; exp++) { // This is used as the exponent to calculate the size of the set.
      int size = (int) Math.pow(2, exp);

      // Do the experiment multiple times, and average out the results
      long totalTime = 0;

      // SET UP!
      for (int iter = 0; iter < ITER_COUNT; iter++) {
        BinarySearchSet<Integer> bss = new BinarySearchSet<Integer>(new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
          }
        });
        for (int i = 0; i < size; i++) {
          bss.add(random.nextInt());
        }
        int element = random.nextInt(); // This gets me a random int between 0 and size;
        bss.add(element);
        bss.remove(element);
        // TIME IT!
        long start = System.nanoTime();
        bss.add(element);
        long stop = System.nanoTime();
        totalTime += stop - start;
      }

      double averageTime = totalTime / (double) ITER_COUNT;
      System.out.println(size + "\t" + averageTime); // print to console
    }

  }

}
