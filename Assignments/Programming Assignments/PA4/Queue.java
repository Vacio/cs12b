//-----------------------------------------------------------------------------
// NAME: AISHNI PARAB
// CRUZID: APARAB
// CLASS: CMPS 12B
// DATE: AUGUST 2 2015
// FILENAME: Queue.java
// DESCRIPTION: Implements Queue ADT Interface
//-----------------------------------------------------------------------------

public class Queue implements QueueInterface {

  //private inner Node class
  private class Node{
    Object item;
    Node next;

    Node(Object item) {
      this.item = item;
      next = null;
    }
  }

  //Fields
  private Node front;
  private Node back;
  private int numItems;

  //Queue constructor
  Queue() {
    front = null;
    back = null;
    numItems = 0;
  }

  // isEmpty()
  // pre: none
  // post: returns true if this Queue is empty, false otherwise
  public boolean isEmpty(){
    return (numItems==0);
  }

  // length()
  // pre: none
  // post: returns the length of this Queue.
  public int length(){
    return numItems;
  }

  // enqueue()
  // adds newItem to back of this Queue
  // pre: none
  // post: !isEmpty()
  public void enqueue(Object newItem){
    if(front == null){
      front = new Node(newItem);
      numItems++;
    } else{
        Node N = front;
        while(N.next != null){
          N = N.next;
        }
        N.next = new Node(newItem);
        back = N.next;
        numItems++;
    }
  }

  // dequeue()
  // deletes and returns item from front of this Queue
  // pre: !isEmpty()
  // post: this Queue will have one fewer element
  public Object dequeue() throws QueueEmptyException{
    if(front == null){
      throw new QueueEmptyException("Usage: using dequeue() on empty queue stack");
    } else{
        Node N = front;
        front = N.next;
        numItems--;
        return N.item;
    }
  }

  // peek()
  // pre: !isEmpty()
  // post: returns item at front of Queue
  public Object peek() throws QueueEmptyException{
    if(front == null){
      throw new QueueEmptyException("Usage: using peek() on empty queue stack");
    } else{
        return front.item;
    }
  }

  // dequeueAll()
  // sets this Queue to the empty state
  // pre: !isEmpty()
  // post: isEmpty()
  public void dequeueAll() throws QueueEmptyException{
    if(front == null){
      throw new QueueEmptyException("Usage: using dequeueAll() on empty queue stack");
    } else{
        front = null;
        back = null;
        numItems = 0;
    }
  }

  // toString()
  // overrides Object's toString() method
  public String toString(){
    String str="";
    Node N = front;
    while(N != null){
      str += N.item + " ";
      N = N.next;
    }
    return str;
  }

}
