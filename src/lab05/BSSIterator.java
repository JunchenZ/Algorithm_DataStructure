package lab05;

import java.util.Iterator;

public class BSSIterator<E> implements Iterator<Object> {

  private int position;
  private BinarySearchSet<E> binarySearchSet;

  @SuppressWarnings("unchecked")
  public BSSIterator(BinarySearchSet<E> binarySearchSet) {
    this.binarySearchSet = binarySearchSet;
    position = 0;
  }

  /**
   * Returns true if the iteration has more elements. (In other words, returns
   * true if next would return an element rather than throwing an exception.)
   */
  @Override
  public boolean hasNext() {
    if (position < binarySearchSet.size()) {
      return true;
    }
    return false;
  }

  /**
   * Returns the next element in the iteration.
   */
  @Override
  public Object next() {
    return binarySearchSet.toArray()[position++];
  }

}
