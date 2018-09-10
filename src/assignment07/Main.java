package assignment07;

import java.util.Random;

public class Main {

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    while(System.nanoTime() - startTime < 1_000_000_000);
    
    int size = 100000;
    String[] arr = new String[size];
    Random rand = new Random();
    for (int i = 0; i < size; i++) {
      String str = "";
      int length = 1 + rand.nextInt(9);
      for (int j = 0; j < length; j++) {
        str += (char) ('a' + rand.nextInt(25));
      }
      arr[i] = str;
    }
//    System.out.println("size" + "\t" + "collisions");
//    for (int i = 8; i < 28; i++) {
//      ChainingHashTable cht = new ChainingHashTable((int) Math.pow(2, i), new MediocreHashFunctor());
//      int collisions = 0;
//      for (int j = 0; j < arr.length; j++) {
//        if (cht.collisions(arr[j])) {
//          collisions++;
//        }
//        cht.add(arr[j]);
//      }
//      System.out.println((int) Math.pow(2, i) + "\t" + collisions);
//    }
    for(int i = 8; i < 20; i++) {
      ChainingHashTable cht = new ChainingHashTable((int) Math.pow(2, i), new MediocreHashFunctor());
      startTime = System.nanoTime();
      for(int k = 0; k < 10; k++) {
        for(int j = 0; j < arr.length; j++) {
          cht.add(arr[j]);
        }
        for(int j = 0; j < arr.length; j++) {
          cht.remove(arr[j]);
        }
      }     
      long endTime = System.nanoTime();
      long time = (endTime - startTime)/10;
      System.out.println((int) Math.pow(2, i) + "\t" + time);
    }

  }

}
