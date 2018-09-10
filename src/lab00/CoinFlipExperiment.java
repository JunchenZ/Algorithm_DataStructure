package lab00;

public class CoinFlipExperiment {

  public static void main(String[] args) {
    int[] counts = new int[201];

    for (int i = 0; i < 10000; i++) {
      int amount = coinFlipExperiment();
      counts[amount + 100] = counts[amount + 100] + 1;
    }

    System.out.println("Likelihood of win/loss amount after 100 flips:");

    System.out.print("Amount");
    System.out.print("\t"); // A tab character
    System.out.print("Probability");
    System.out.println();

    // Loop through amounts

    double attempts = 10000.0;
    for (int i = 0; i <= 200; i++) {
      System.out.print(i - 100);
      System.out.print("\t");
      System.out.print(counts[i] / attempts);
      System.out.println();
    }
  }

  /**
   * Returns the amount of money you'd win or lose by flipping an unbalanced coin
   * 100 times.
   *
   * @return the amount of money won/lost
   */
  static public int coinFlipExperiment() {
    int winnings = 0; // declare and set the winning time to 0

    for (int i = 0; i < 100; i++) {
      double flip = Math.random(); // get a random number representing the probability of coin flip

      if (flip < 0.505) { // if the number > 0.505 then make it "head" as the probability is 0.505
        winnings++; // if get a head then win 1 dollar
      } else {
        winnings--; // if get a tail then lose 1 dollar
      }
    }

    return winnings;
  }
}
