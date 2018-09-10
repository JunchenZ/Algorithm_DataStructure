package lab02;

public class TimingSqrt {

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    for(int i = 1; i<=10; i++) {
      Math.sqrt(i);
    }
    long currentTime = System.nanoTime();
    System.out.println(currentTime - startTime);
  }

}
