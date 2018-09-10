package lab06;

public class BetterRandomNumberGenerator implements RandomNumberGenerator {

  private long seed, a, c;

  @Override
  public int nextInt(int max) {
    return (int) (seed = ((a * seed + c) % max));
  }

  @Override
  public void setSeed(long seed) {
    this.seed = seed;
  }

  @Override
  public void setConstants(long const1, long const2) {
    a = const1;
    c = const2;
  }

}
