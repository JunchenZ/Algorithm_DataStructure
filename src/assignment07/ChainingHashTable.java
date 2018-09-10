package assignment07;

import java.util.Collection;
import java.util.LinkedList;

public class ChainingHashTable implements Set<String> {

  private LinkedList<String>[] storage;
  private HashFunctor functor;
  private int size;

  @SuppressWarnings("unchecked")
  public ChainingHashTable(int capacity, HashFunctor functor) {
    storage = (LinkedList<String>[]) new LinkedList[capacity];
    this.functor = functor;
    size = 0;
  }

  @Override
  public boolean add(String item) {
    if(contains(item)) {
      return false;
    }
    //calculate the index in which the item should be inserted
    int index = functor.hash(item) % storage.length;
    if(storage[index] == null){
      storage[index] = new LinkedList<String>();
    }
    storage[index].add(item);
    size++;
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends String> items) {
    int  tempSize = size;
    for (String str : items) {
      add(str);
    }
    return size > tempSize;
  }

  @Override
  public void clear() {
    for(LinkedList<String> ll : storage) {
      if(ll != null) {
        ll.clear();
      }
    }
    size = 0;
  }

  @Override
  public boolean contains(String item) {
    int index = functor.hash(item) % storage.length;
    if (storage[index] != null) {
      return storage[index].contains(item);
    }
    return false;
  }

  @Override
  public boolean containsAll(Collection<? extends String> items) {
    for (String str : items) {
      if (!contains(str)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean remove(String item) {
    int index = functor.hash(item) % storage.length;
    boolean removed = (storage[index] != null) && storage[index].remove(item);
    if(removed) {
      size--;
    }
    return removed;
  }

  @Override
  public boolean removeAll(Collection<? extends String> items) {
    int tempSize = size;
    for (String str : items) {
      remove(str);
    }
    return size < tempSize;
  }

  @Override
  public int size() {
    return size;
  }
  
  public boolean collisions(String item) {
    int index = functor.hash(item) % storage.length;
    return storage[index] != null;
  }

}
