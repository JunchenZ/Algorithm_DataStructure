package assignment06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<? super T>> implements SortedSet<T> {

  Node root;
  int size;

  public BinarySearchTree() {
    root = null;
    size = 0;
  }

  private class Node {
    T data;
    Node left;
    Node right;

    Node(T item) {
      data = item;
      left = null;
      right = null;
    }
  }
  
  @Override
  public boolean add(T item) {
    if (contains(item)) {
      return false;
    }

    if (isEmpty()) {
      root = new Node(item);
      size++;
      return true;
    }
    
    insert(root, item);
    size++;
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends T> items) {
    int tempSize = size;

    for (T element : items) {
      add(element);
    }

    return size > tempSize;
  }

  @Override
  public void clear() {
    root = null;
    size = 0;
  }

  @Override
  public boolean contains(T item) {
    return (size > 0) && (root.data.equals(item) || findParentNode(root, item) != null);
  }

  @Override
  public boolean containsAll(Collection<? extends T> items) {
    for (T element : items) {
      if (!contains(element)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public T first() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return findSmallestNode(root).data;
  }

  @Override
  public boolean isEmpty() {
    return root == null;
  }

  @Override
  public T last() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    Node node = root;
    while (node.right != null) {
      node = node.right;
    }
    return node.data;
  }

  @Override
  public boolean remove(T item) {
    if (!contains(item)) {
      return false;
    }

    if (root.data.equals(item)) {
      if(size == 1) {
        root = null;
      }else if(root.left == null){
        root = root.right;
      }else if(root.right == null) {
        root = root .left;
      }else {
        root.data = findSmallestNode(root).data;
        deleteNode(findParentNode(root,root.data), root.data);
      }      
    } else {
      //to delete the node, first find its parent node 
      Node parentNode = findParentNode(root, item);
      delete(parentNode, item);
    }

    size--;
    return true;
  }

  @Override
  public boolean removeAll(Collection<? extends T> items) {
    int tempSize = size;
    for (T element : items) {
      remove(element);
    }
    return size < tempSize;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public ArrayList<T> toArrayList() {  // -- in order traversal
    ArrayList<T> al = new ArrayList<T>(size);
    dftInOrder(root, al);
    return al;
  }

  /**
   * @param node
   *          under which the parent node of a node holds the item is to be found
   * @param item
   * @return
   */
  private Node findParentNode(Node node, T item) {
    Node parentNode = node;

    // if the the node is a leaf node, then it is not the parent node required
    if (parentNode.left == null || parentNode.right == null) {
      return null;
    }

    // if a child node of the parentNode holds the item, return the parentNode
    if (parentNode.left.data.equals(item) || parentNode.right.data.equals(item)) {
      return parentNode;
    }

    if (parentNode.data.compareTo(item) <= 0) { // if the item is no less than the data of the node
      // do the recursive for the right child of the node
      parentNode = parentNode.right;
      if (findParentNode(parentNode, item) != null) {
        return findParentNode(parentNode, item);
      }
    } else { // if the item is less than the data of the node
      // do the recursive for the left child of the node
      parentNode = parentNode.left;
      if (findParentNode(parentNode, item) != null) {
        return findParentNode(parentNode, item);
      }
    }

    // if no case is matched, return null
    return null;
  }

  /**
   * @param parentNode
   *          under which the item is to be inserted
   * @param item
   */
  private void insert(Node parentNode, T item) {
    if (parentNode.data.compareTo(item) > 0) { // if the item is less than the data of parentNode
      
      if (parentNode.left == null) { // if the parentNode has no left child then put the item there
        parentNode.left = new Node(item);
      } else { // if the parentNode has a left child, do the recursive
        insert(parentNode.left, item);
      }
    } else { // if the item is no less than the data of parentNode
      
      if (parentNode.right == null) { // if the parentNode has no right child then put the item there
        parentNode.right = new Node(item);
      } else { // if the parentNode has a right child, do the recursive
        insert(parentNode.right, item);
      }
    }
  }

  /**
   * @param parent
   *          node, under which a child has smallest data
   * @return the child node
   */
  private Node findSmallestNode(Node parentNode) { // just use parentNode  
    Node node = parentNode;
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  /**
   * @param node
   * 
   */
  public void deleteNode(Node parentNode, T item) {     
    if(parentNode.left != null && parentNode.left.data.equals(item)) {
      if(parentNode.left.right == null) {
        parentNode.left = null;
      }else {
        parentNode.left = parentNode.left.right;
      }     
    }else {
      if(parentNode.right.right == null) {
        parentNode.right = null;
      }else {
        parentNode.right = parentNode.right.right;
      } 
    }
  }
  
  private void dftInOrder(Node node, ArrayList<T> al) {
    if(node == null) {
      return ;
    }
    
    dftInOrder(node.left, al);
    
    al.add(node.data);
    
    dftInOrder(node.right, al);
    
  }

  private void delete(Node parentNode, T item) {
    if(parentNode.left.data.equals(item)) {
      if(parentNode.left.left == null && parentNode.left.right == null) {
        parentNode.left = null;
      }else if(parentNode.left.left == null) {
        parentNode.left = parentNode.left.right;
      }else if(parentNode.left.right == null) {
        parentNode.left = parentNode.left.left;
      }else {
        parentNode.left.data = findSmallestNode(parentNode.left).data;
        deleteNode(findParentNode(parentNode.left, parentNode.left.data), parentNode.left.data);
      }
    }else {
      if(parentNode.right.left == null && parentNode.right.right == null) {
        parentNode.right = null;
      }else if(parentNode.right.left == null) {
        parentNode.right = parentNode.right.right;
      }else if(parentNode.right.right == null) {
        parentNode.right = parentNode.right.left;
      }else {
        parentNode.right.data = findSmallestNode(parentNode.right).data;
        deleteNode(findParentNode(parentNode.right, parentNode.right.data), parentNode.right.data);
      }
    }
  }
  
}
