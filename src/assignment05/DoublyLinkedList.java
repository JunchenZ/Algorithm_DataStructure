package lab07;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements List<E>, Iterable<E> {

  Node head;  
  Node tail;
  int size;
  
  public DoublyLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public Iterator<E> iterator() {
    return new DLLIterator(this.head);
  }

  @Override
  public void addFirst(E element) {
    if (size == 0) {
      head = new Node(element, null, null);
      tail = head;
    } else {
      Node temp = new Node(element, null, head);
      head.prev = temp;
      head = temp;
    }
    size++;
  }

  @Override
  public void addLast(E o) {
    if (size == 0) {
      head = new Node(o, null, null);
      tail = head;
    } else {
      Node temp = new Node(o, tail, null);
      tail.next = temp;
      tail = temp;
    }
    size++;
  }

  @Override
  public void add(int index, E element) throws IndexOutOfBoundsException {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      addFirst(element);
    } else if (index == size) {
      addLast(element);
    } else {
      Node node = head;     
      for (int i = 0; i < index; i++) {
        node = node.next;
      }
      Node temp = new Node(element, node.prev, node);
      node.prev = temp;
      temp.prev.next = temp;
      size++;
    }   
  }

  @Override
  public E getFirst() throws NoSuchElementException {
    if(size == 0) {
      throw new NoSuchElementException();
    }else {
      return (E) head.data;
    }
  }

  @Override
  public E getLast() throws NoSuchElementException {
    if(size == 0) {
      throw new NoSuchElementException();
    }else {
      return (E) tail.data;
    }
  }

  @Override
  public E get(int index) throws IndexOutOfBoundsException {
    if(index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node temp = head;
    for(int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return (E) temp.data;
  }

  @Override
  public E removeFirst() throws NoSuchElementException {
    if(size == 0) {
      throw new NoSuchElementException();
    }else {
      Node temp = head;
      head = temp.next;
      if(head!=null) {
        head.prev = null;
      }    
      size--;
      if(size == 0) {
        tail = null;
      }
      return (E) temp.data;
    }
  }

  @Override
  public E removeLast() throws NoSuchElementException {
    if(size == 0) {
      throw new NoSuchElementException();
    }else {
      Node temp = tail;
      tail = temp.prev;
      if(tail!=null) {
        tail.next = null;
      }
      size--;
      if(size == 0) {
        head = null;
      }
      return (E) temp.data;
    }
  }

  @Override
  public E remove(int index) throws IndexOutOfBoundsException {
    if(index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      return removeFirst();
    } else if (index == size-1) {
      return removeLast();
    }else {
      Node node = head;
      for(int i = 0; i < index; i++) {
        node = node.next;
      }
      node.prev.next = node.next;
      node.next.prev = node.prev;
      size--;
      return (E) node.data;
    }   
  }

  @Override
  public int indexOf(E element) {
    Node node = head;
    for(int i = 0; i < size; i++) {
      if(node.data == element) {
        return i;
      }
      node = node.next;
    }
    return -1;
  }

  @Override
  public int lastIndexOf(E element) {
    Node node = tail;
    for(int i = size-1; i>=0; i--) {
      if(node.data == element) {
        return i;
      }
      node = node.prev;
    }
    return -1;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size==0;
  }

  @Override
  public void clear() {
    size = 0;
    head = null;
    tail = null;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[size];
    int i = 0;
    for(Iterator<E> itr = this.iterator(); itr.hasNext();) {
      arr[i++] = itr.next();
      itr.remove();
    }
    return arr;
  }
  
  private class Node {   
    E data;
    Node prev;
    Node next;
    
    /**
     * @param element
     * @param prev
     * @param next
     */
    public Node(E element, Node prev, Node next) {
      data = element;
      this.prev = prev;
      this.next = next;
    }
  }
  
  public class DLLIterator implements Iterator<E> {  

    private Node node;
    
    public DLLIterator(Node head) {
      node = head;
    }
    
    @Override
    public boolean hasNext() {
      return node!= null;
    }

    @Override
    public E next() {
      if(hasNext()) {
        return (E) node.data;
      }else {
        throw new NoSuchElementException();
      }
    }
    
    @Override
    public void remove() {
      node = node.next;
    }

  }

}
