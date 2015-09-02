import java.util.*;

public class Extrema {

  //maxArray function is the recursive function that breaks the array into subarrays and compares the array items to find the maximum value.
  static int maxArray(int[] A, int p, int r){
    int q = 0;
    if (p<r) {
      q = (p+r)/2;
      //System.out.println(p+" "+q+" "+r);

      //Finds maximum value of the left subarray.
      int maxLeft = maxArray(A, p, q);

      //Finds the maximum value of the right subarray.
      int maxRight = maxArray(A, q+1, r);

      //Compares the left and right maximum values to find the maximum between the two.
      int maxFinal = max(maxLeft, maxRight);
      return maxFinal;
    }
    //Returns the element of the array at position r (which is the max of the smallest subarray).
    return A[r];
  }

  //max helper function compares p and r to find the maximum between the two.
  static int max(int p, int r){
    int maxValue = 0;
      if (p > r) {
        maxValue = p;
     } else {
       maxValue = r;
     }
     return maxValue;
  }

  //minArray function is the recursive function that breaks the array into subarrays and compares the array items to find the minimum value.
  static int minArray(int[] A, int p, int r){
    int q = 0;
    if (p<r) {
      q = (p+r)/2;
      //System.out.println(p+" "+q+" "+r);

      //Finds minimum value of the left subarray.
      int minLeft = minArray(A, p, q);

      //Finds minimum value of the right subarray.
      int minRight = minArray(A, q+1, r);

      //Compares the left and right minimum values to find the minimum between the two.
      int minFinal = min(minLeft, minRight);
      return minFinal;
    }
    //Returns the element of the array at position r (which is the min of the smallest subarray).
    return A[r];
  }

  //min helper function compares p and r to find the maximum between the two.
  static int min(int p, int r){
    int minValue = 0;
      if (p > r) {
        minValue = r;
     } else {
       minValue = p;
     }
     return minValue;
  }

  //main method that defines the array and its elements and calls the max and min methods on it.
  public static void main (String[] args){
      int[] B = {-1, 2, 6, 3, 9, 2, -3, -2, 11, 5, 7};
      System.out.println("max = " + maxArray(B, 0, B.length-1)); //output: max = 11
      System.out.println("min = " + minArray(B, 0, B.length-1)); //output: min = -3
  }

}
