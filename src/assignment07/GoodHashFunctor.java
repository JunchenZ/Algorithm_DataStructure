package assignment07;

public class GoodHashFunctor implements HashFunctor {

  @Override
  public int hash(String item) {
    long hash = 7;
    for (char c : item.toCharArray()) {
      hash = hash * 31 + c;
    }
    return (int) (hash % Integer.MAX_VALUE);
  }

}
