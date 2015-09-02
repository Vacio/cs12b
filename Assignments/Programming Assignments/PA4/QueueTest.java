//-----------------------------------------------------------------------------
// NAME: AISHNI PARAB
// CRUZID: APARAB
// CLASS: CMPS 12B
// DATE: AUGUST 2 2015
// FILENAME: QueueTest.java
// DESCRIPTION: Tests the implementation of Queue ADT Interface
//-----------------------------------------------------------------------------

public class QueueTest{
  public static void main (String[] args){
    Queue A = new Queue();

    System.out.println(A.isEmpty()); //true
    //adds to the Queue
    A.enqueue((int)1);
    A.enqueue((int)2);
    A.enqueue((int)3);
    A.enqueue((int)4);
    A.enqueue((int)5);
    System.out.println(A.isEmpty()); //false
    System.out.println(A.length()); //5
    System.out.println(A); //1 2 3 4 5
    A.dequeue(); //deletes one
    A.dequeue(); //deletes one
    System.out.println(A.length()); //3
    System.out.println(A); //3 4 5
    System.out.println(A.peek()); //returns 3 (front)
    A.dequeueAll(); //removes everything from Queue
    System.out.println(A.isEmpty()); //prints true
    A.dequeue(); //throws exception
  }
}
