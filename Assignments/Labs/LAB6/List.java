//-----------------------------------------------------------------------------
// NAME: AISHNI PARAB
// CRUZID: APARAB
// CLASS: CMPS 12B
// DATE: AUGUST 3 2015
// FILENAME: List.java
// DESCRIPTION: Implements Linked List IntegerList ADT using Generics
//-----------------------------------------------------------------------------

public class List<T> implements ListInterface<T> {

  //private inner Node class
  private class Node{
    T item;
    Node next;

    Node (T x){
      item = x;
      next = null;
    }
  }

  //list class fields
  private Node head;
  private int numItems;

  //List() constructor for IntegerList class
  public List(){
    head = null;
    numItems = 0;
  }

  //helper function
  //find()
  //pre: none
  //post: returns reference to Node at position index in List
  private Node find(int index){
    Node N = head;
    for(int i=1; i<index; i++) N = N.next;
    return N;
  }

  //ADT OPERATIONS

  // isEmpty
  // pre: none
  // post: returns true if this List is empty, false otherwise
  public boolean isEmpty(){
    return(numItems == 0);
  }

  // size
  // pre: none
  // post: returns the number of elements in this List
  public int size(){
    return numItems;
  }

  // get
  // pre: 1 <= index <= size()
  // post: returns item at position index
  public T get(int index) throws ListIndexOutOfBoundsException{
    if(index<1 || index>numItems){
      throw new ListIndexOutOfBoundsException("get(): invalid index: " + index);
    }
    Node N = find(index);
    return N.item;
  }

  // add
  // inserts newItem in this List at position index
  // pre: 1 <= index <= size()+1
  // post: !isEmpty(), items to the right of newItem are renumbered
  public void add(int index, T newItem) throws ListIndexOutOfBoundsException{
    if(index<1 || index>numItems+1){
      throw new ListIndexOutOfBoundsException("add(): invalid index: " + index);
    }
    if(index==1){
      Node N = new Node(newItem);
      N.next = head;
      head = N;
    } else{
        Node P = find(index-1);
        Node C = P.next;
        P.next = new Node(newItem);
        P = P.next;
        P.next = C;
    }
    numItems++;
  }

  // remove
  // deletes item from position index
  // pre: 1 <= index <= size()
  // post: items to the right of deleted item are renumbered
  public void remove(int index) throws ListIndexOutOfBoundsException{
    if(index<1 || index>numItems){
      throw new ListIndexOutOfBoundsException("remove(): invalid index: " + index);
    }
    if(index==1){
      Node N = head;
      head = head.next;
      N.next = null;
    } else{
        Node P = find(index-1);
        Node N = P.next;
        P.next = N.next;
        N.next = null;
    }
    numItems++;
  }

  // removeAll
  // pre: none
  // post: isEmpty()
  public void removeAll(){
    head = null;
    numItems = 0;
  }

  // toString()
  // pre: none
  // post: prints currents state to stdout
  // Overrides Object's toString() method
  public String toString(){
    String s = "";
    for(Node N = head; N != null; N = N.next){
      s += N.item.toString() + " ";
    }
    return s;
  }

  // equals()
  // pre: none
  // post: returns true if this IntegerList matches rhs, false otherwise
  // Overrides Object's equals() method
  @SuppressWarnings("unchecked")
  public boolean equals(Object rhs){
    boolean eq = false;
    List<T> R = null;
    Node N = null;
    Node M = null;

    if(this.getClass()==rhs.getClass()){
      R = (List<T>)rhs;
      eq = (this.numItems == R.numItems);

      N = this.head;
      M = R.head;
      while(eq && N!= null){
        eq = (N.item == M.item);
        N = N.next;
        M = M.next;
      }
    }
    return eq;
  }
}
