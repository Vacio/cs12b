  //-----------------------------------------------------------------------------
  // NAME: AISHNI PARAB
  // CRUZID: APARAB
  // CLASS: CMPS 12M
  // DATE: AUGUST 10 2015
  // FILENAME: Dictionary.java
  // DESCRIPTION: Implements Dictionary ADT using BST
  //-----------------------------------------------------------------------------

  public class Dictionary implements DictionaryInterface {

  //private inner Node class
  private class Node{
    Pair item;
    Node left;
    Node right;

    Node(Pair x){
      item = x;
      left = null;
      right = null;
    }
  }

  //private inner Pair class
  private class Pair{
    String key;
    String value;

    Pair(String x, String y){
      key = x;
      value = y;
    }
  }

  //fields for Dictionary class
  private Node root;      //root is the first Node in List
  private int numItems;   //numItems in number of Dictionary items

  //Dictionary() constructor
  public Dictionary(){
    root = null;
    numItems = 0;
  }

  //private helper functions----------------------------------------------------

  //findKey()
  //returns Node that has key, k, in subtree root
  //returns NULL if no such Node exists
  private Node findKey(Node R, String targetKey){
    if(R==null || R.item.key.equals(targetKey)) return R;
    if(R.item.key.compareToIgnoreCase(targetKey)>0) return findKey(R.left, targetKey);
    else return findKey(R.right, targetKey);
  }

  //findParent()
  //pre: R!=NULL
  //returns parent of N in the subtree rooted R
  //returns NULL if N is equal to R
  Node findParent(Node N, Node R){
    Node P = null;
    if(N!=R){
      P=R;
      while(P.left!=N && P.right!=N){
        if(N.item.key.compareToIgnoreCase(P.item.key)<0){
          P = P.left;
        }
        else{
          P = P.right;
        }
      }
    }
    return P;
  }

  //findLeftmost()
  //returns leftmost Node in the subtree rooted R
  //returns NULL if R is NULL
  Node findLeftmost(Node R){
   Node L = R;
   if( L!= null ) for( ; L.left != null; L = L.left);
    return L;
   }

  // printInOrder()
  // prints (key, value) pairs from the subtree rooted at R in ascending order
  void printInOrder(Node R){
    if( R != null ){
      printInOrder(R.left);
      System.out.println(R.item.key + " " + R.item.value);
      printInOrder(R.right);
    }
  }

  // deleteAll()
  // deletes all Nodes in the subtree rooted at N.
  void deleteAll(Node N){
    if( N != null ){
      deleteAll(N.left);
      deleteAll(N.right);
    }
  }

  // ADT operations ------------------------------------------------------------

  // isEmpty()
  // pre: none
  // post: returns true if this Dictionary is empty, false otherwise
  public boolean isEmpty(){
    return(numItems == 0);
  }

  // size()
  // pre: none
  // post: returns the number of elements in this Dictionary
  public int size() {
    return numItems;
  }

  // lookup
  // pre: none
  // post: returns value associated key, or null reference if no such key exists
  public String lookup(String key){
    Node N;
    N = findKey(root, key);
    return ( N == null ? null : N.item.value );
  }

  // insert()
  // inserts new (key,value) pair into this Dictionary
  // pre: lookup(key)==null
  // post: !isEmpty(), size() is increased by one
  public void insert(String key, String value) throws DuplicateKeyException{
    Node N, A, B;
    if(findKey(root, key)!=null){
      throw new DuplicateKeyException("Dictionary Error: insert() cannot insert duplicate keys");
    }
    N = new Node(new Pair(key, value));
    B = null;
    A = root;
    while( A != null ){
      B = A;
      if(A.item.key.compareToIgnoreCase(key)>0) A = A.left;
      else A = A.right;
    }

    if( B == null ) root = N;
    else if(B.item.key.compareToIgnoreCase(key)>0) B.left = N;
    else B.right = N;
    numItems++;
  }

  // delete()
  // deletes pair with the given key
  // pre: lookup(key)!=null
  public void delete(String key) throws KeyNotFoundException{
    Node N, P, S;
    if(findKey(root, key)==null){
      throw new KeyNotFoundException("Dictionary Error: delete() cannot delete non-existent key");
    }
    N = findKey(root, key);
    if( N.left == null && N.right == null ){
      if( N == root ){
        root = null;
      }else{
        P = findParent(N, root);
        if( P.right == N ) P.right = null;
        else P.left = null;
      }
    }else if( N.right == null ){
      if( N == root ){
        root = N.left;
      }else{
        P = findParent(N, root);
        if( P.right == N ) P.right = N.left;
        else P.left = N.left;
      }
    }else if( N.left == null ){
      if( N == root ){
        root = N.right;
      }else{
        P = findParent(N, root);
        if( P.right == N ) P.right = N.right;
        else P.left = N.right;
      }
    }else{  
      S = findLeftmost(N.right);
      N.item.key = S.item.key;
      N.item.value = S.item.value;
      P = findParent(S, N);
      if( P.right == S ) P.right = S.right;
      else P.left = S.right;
    }
    numItems--;
  }

  // makeEmpty
  // pre: none
  public void makeEmpty(){
    deleteAll(root);
    root = null;
    numItems = 0;
  }

  // toString()
  // Overrides Object's toString() method
  public String toString(){
    printInOrder(root);
    return "";
  }
}
