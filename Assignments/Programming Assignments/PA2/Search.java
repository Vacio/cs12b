//-----------------------------------------------------------------------------------------------------------------------------------------------
//NAME: AISHNI PARAB
//CRUZID: APARAB
//CLASS: CMPS 12B
//DATE: JULY 8 2015
//FILENAME: Search.java
//DESCRIPTION: This program takes command line arguments giving a file to be searched and target word(s) to search for.
//-----------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;


class Search{

   public static void main(String[] args) throws IOException {
      int h = 0;
      int i = 0;
      int location = 0;
      int[] line;
      String[] file;

      //Prints message and exits program if less than 2 arguments are provided
      if(args.length < 2) {
         System.out.println("Usage: Search file target1 [target2 ..]");
         System.exit(1);
      }
      //Count the number of lines in a file
      Scanner in = new Scanner(new File(args[0]));

      while( in.hasNextLine() ){
         in.nextLine();
         h++;
      }
      file = new String[h];
      line = new int[h];

      Scanner in1 = new Scanner(new File(args[0]));

      while( in1.hasNextLine() ){
         file[i] = in1.nextLine();
         line[i] = i;
         i++;
      }
      //calls the mergeSort method
      mergeSort(file, line, 0, h-1);

      //calls the binarySearch method
      for(i=1; i<args.length; i++){
         location = binarySearch(file, 0, h-1, args[i]);
         if( !(binarySearch(file, 0, h-1, args[i]) == -1) ){
            location = line[location]+1;
            System.out.println(args[i]+" found on line "+ location);
         } else {
            System.out.println(args[i]+ " not found");
         }
      }
   }

   public static void mergeSort(String[] word, int[] lineNumber, int p, int r){
      int q;
      if(p < r) {
     q = (p+r)/2;
        mergeSort(word, lineNumber, p, q);
        mergeSort(word, lineNumber, q+1, r);
        merge(word, lineNumber, p, q, r);
      }
   }

   public static void merge(String[] word, int[] lineNumber, int p, int q, int r){
      int a = q-p+1;
      int b = r-q;
      String[] L = new String[a];
      String[] R = new String[b];
      int[] L_num = new int[a];
      int[] R_num = new int[b];
      int i, j, k;

      for(i=0; i<a; i++) {
         L[i] = word[p+i];
         L_num[i] = lineNumber[p+i];
      }
      for(j=0; j<b; j++){
          R[j] = word[q+j+1];
          R_num[j] = lineNumber[q+j+1];
      }
      i = 0; j = 0;
      for(k=p; k<=r; k++){
         if( i<a && j<b ){
            if( L[i].compareTo(R[j])<0 ){
               word[k] = L[i];
               lineNumber[k] = L_num[i];
               i++;
            }else{
               word[k] = R[j];
               lineNumber[k] = R_num[j];
               j++;
            }
		  }else if( i<a ){
            word[k] = L[i];
            lineNumber[k] = L_num[i];
            i++;
         }else{
            word[k] = R[j];
            lineNumber[k] = R_num[j];
            j++;
         }
      }
   }

   public static int binarySearch(String[] A, int p, int r, String target){
         int q;
         if(p > r) {
            return -1;
        }else{
           q = (p+r)/2;
        if(target.compareTo(A[q])==0){
           return q;
        }else if(target.compareTo(A[q])<0){
           return binarySearch(A, p, q-1, target);
        }else{
           return binarySearch(A, q+1, r, target);
        }
      }
   }
}
