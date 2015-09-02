//-----------------------------------------------------------------------------
// Dictionary.java
// implementation of the Dictionary ADT
//-----------------------------------------------------------------------------
//ACCOUNT FOR VALUE!!
public class Dictionary implements DictionaryInterface {

  // private inner Node class
  private class Node {
    String key;
    String value;
    Node next;

    // node class constructor
    Node(String key, String value) {
      this.key = key;
      this.value = value;
      next = null;
    }
  }

  // Fields for the Dictionary class
  private Node head;      // reference to first Node in Dictionary
  private int numItems;   // number of items in this Dictionary

  // Dictionary()
  // constructor for the Dictionary class
  public Dictionary() {
    head = null;
    numItems = 0;
  }

  // private helper function -------------------------------------------------

   // findKey()
   // returns a reference to the Node at position key in this Dictionary
   private Node findKey(String key) {
     Node N = head;
     while (N != null){
       if(N.key.equals(key)){
         return N;
       } else {
          N = N.next;
       }
     }
      return null;
   }


   // ADT operations ----------------------------------------------------------

   // isEmpty()
   // pre: none
   // returns true if this Dictionary is empty, false otherwise
   public boolean isEmpty() {
     return (numItems==0);
   }

   // size()
   // pre: none
   // returns the number of entries in this Dictionary
   public int size() {
     return numItems;
   }

   // lookup()
   // pre: none
   // returns value associated key, or null reference if no such key exists
   public String lookup(String key) {
     Node N = head;
     while (N != null){
       if (N.key.equals(key)){
         return N.value;
       }
       N = N.next;
     }
     return null;
   }

   // insert()
   // inserts new (key,value) pair into this Dictionary
   // pre: lookup(key)==null
   public void insert(String key, String value) throws DuplicateKeyException {
     if (lookup(key) != null){
       throw new DuplicateKeyException("cannot insert duplicate keys");
     } else {
          if (head == null){
            Node N = new Node(key,value);
            head = N;
            numItems++;
          } else {
              Node N = head;
              while (N != null){
                if(N.next == null){
                  break;
                }
                N = N.next;
              }
              N.next = new Node(key,value);
              numItems++;
            }
        }
  }

  // delete()
  // deletes pair with the given key
  // pre: lookup(key)!=null
  public void delete(String key) throws KeyNotFoundException {
    if( lookup(key) == null){
      throw new KeyNotFoundException("cannot delete non-existent key");
    } else {
        //removes first element
        if(numItems <= 1){
          Node N = head;
          head = head.next;
          N.next = null;
          numItems--;
        } else {
          Node N = head;
          if(N.key.equals(key)){
            head = N.next;
            numItems--;
          } else {
              while(!N.next.key.equals(key)) {
                N = N.next;
            }
          N.next = N.next.next;
          numItems--;
          }
        }
      }
  }

  // makeEmpty()
  // pre: none
  public void makeEmpty(){
    head = null;
    numItems = 0;
  }

  // toString()
  // returns a String representation of this Dictionary
  // overrides Object's toString() method
  // pre: none
  public String toString() {
    StringBuffer sb = new StringBuffer();
    Node N = head;

    for(N = head; N != null; N = N.next) sb.append(N.key).append(" ").append(N.value).append("\n");
     return new String(sb);
  }

}
