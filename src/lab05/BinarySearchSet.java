package lab05;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchSet<E> implements SortedSet<E>, Iterable<E> {

  private E[] sortedSet;
  private Comparator<E> comparator;
  private int size;

  public BinarySearchSet() {
    sortedSet = (E[]) new Object[10];
    size = 0;
  }

  public BinarySearchSet(Comparator<? super E> comparator) {
    sortedSet = (E[]) new Object[10];
    this.comparator = (Comparator<E>) comparator;
    size = 0;
  }

  /**
   * @param element1
   * @param element2
   * @return if lhs < rhs return < 0, lhs > rhs return > 0, lhs = rhs return = 0
   */
  @SuppressWarnings("unchecked")
  public int compare(E element1, E element2) {
    if (comparator == null) {
      return ((Comparable<Comparable<?>>) element1).compareTo((Comparable<?>) element2);
    } else {
      return comparator.compare(element1, element2);
    }
  }

  /**
   * @return The comparator used to order the elements in this set, or null if
   *         this set uses the natural ordering of its elements (i.e., uses
   *         Comparable).
   */
  @Override
  public Comparator<? super E> comparator() {
    return comparator;
  }

  /**
   * @return the first (lowest, smallest) element currently in this set
   * @throws NoSuchElementException
   *           if the set is empty
   */
  @Override
  public E first() throws NoSuchElementException {
    return sortedSet[0];
  }

  /**
   * @return the last (highest, largest) element currently in this set
   * @throws NoSuchElementException
   *           if the set is empty
   */
  @Override
  public E last() throws NoSuchElementException {
    return sortedSet[size - 1];
  }

  /**
   * Adds the specified element to this set if it is not already present and not
   * set to null.
   * 
   * @param o
   *          element to be added to this set
   * @return true if this set did not already contain the specified element
   */
  @Override
  public boolean add(E element) {

    if (this.contains(element)) {
      return false;
    }

    if (size == 0) {
      sortedSet[size++] = element;
      return true;
    }

    if (sortedSet.length == size) {
      E[] newSet = (E[]) new Object[2 * size];
      for (int i = 0; i < size; i++) {
        newSet[i] = sortedSet[i];
      }
      sortedSet = newSet;
    }

    int low = 0, high = size - 1;
    int mid = (low + high) / 2;

    while (low <= high) {
      if (compare(element, sortedSet[mid]) > 0) {
        low = mid + 1;
        mid = (low + high) / 2;
      } else {
        high = mid - 1;
        mid = (low + high) / 2;
      }
    }
    for (int j = size - 1; j >= low; j--) {
      sortedSet[j + 1] = sortedSet[j];
    }
    sortedSet[low] = element;
    size++;
    return true;
  }

  /**
   * Adds all of the elements in the specified collection to this set if they are
   * not already present and not set to null.
   * 
   * @param c
   *          collection containing elements to be added to this set
   * @return true if this set changed as a result of the call
   */
  @Override
  public boolean addAll(Collection<? extends E> elements) {
    int originalSize = size;
    for (E element : elements) {
      add(element);
    }
    if (originalSize < size) {
      return true;
    }
    return false;
  }

  /**
   * Removes all of the elements from this set. The set will be empty after this
   * call returns.
   */
  @Override
  public void clear() {
    sortedSet = (E[]) new Object[10];
    size = 0;
  }

  /**
   * @param o
   *          element whose presence in this set is to be tested
   * @return true if this set contains the specified element
   */
  @Override
  public boolean contains(Object element) {
    if (binarySearch(element) < 0) {
      return false;
    }
    return true;
  }

  /**
   * @param c
   *          collection to be checked for containment in this set
   * @return true if this set contains all of the elements of the specified
   *         collection
   */
  @Override
  public boolean containsAll(Collection<?> elements) {
    for (Object element : elements) {
      if (!this.contains(element)) {
        return false;
      }
    }
    return true;
  }

  /**
   * @return true if this set contains no elements
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * @return an iterator over the elements in this set, where the elements are
   *         returned in sorted (ascending) order
   */
  @Override
  public Iterator<E> iterator() {
    return new BSSIterator(this);
  }

  /**
   * Removes the specified element from this set if it is present.
   * 
   * @param o
   *          object to be removed from this set, if present
   * @return true if this set contained the specified element
   */
  @Override
  public boolean remove(Object element) {
    if (!this.contains(element)) {
      return false;
    }

    for (int i = binarySearch(element); i < size - 1; i++) {
      sortedSet[i] = sortedSet[i + 1];
    }
    size--;
    return true;
  }

  /**
   * Removes from this set all of its elements that are contained in the specified
   * collection.
   * 
   * @param c
   *          collection containing elements to be removed from this set
   * @return true if this set changed as a result of the call
   */
  @Override
  public boolean removeAll(Collection<?> elements) {
    int originalSize = size;
    for (Object element : elements)
      remove(element);
    if (originalSize > size)
      return true;
    return false;
  }

  /**
   * @return the number of elements in this set
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * @return an array containing all of the elements in this set, in sorted
   *         (ascending) order.
   */
  @Override
  public Object[] toArray() {
    return sortedSet;
  }

  public int binarySearch(Object item) {

    int low = 0, high = size - 1;
    int mid = (low + high) / 2;

    while (low <= high) {
      if (compare((E) item, sortedSet[mid]) == 0) {
        return mid;
      } else if (compare((E) item, sortedSet[mid]) > 0) {
        low = mid + 1;
        mid = (low + high) / 2;
      } else {
        high = mid - 1;
        mid = (low + high) / 2;
      }
    }
    return -1;
  }

}
