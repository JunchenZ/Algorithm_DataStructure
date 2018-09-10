package assignment07;

public class MediocreHashFunctor implements HashFunctor {

  @Override
  public int hash(String item) {
    int value = 0;
    for (char c : item.toCharArray()) {
      value += c * c;
    }
    return value;
  }

}
