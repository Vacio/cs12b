import java.io.*;
import java.util.Scanner;

class Reverse1 {
	public static void main(String[] args) throws IOException{
		System.out.println("String reverse");
		stringReverse("hey", 3);
	}

			public static String stringReverse(String s, int n) {
				if (s == "") {
					return s;
				} else if (s.length() == 1) {
					System.out.print(s);
					return s;
				}
					//if s.length() > 1
					//break problem into smaller more solvable pieces
					//recursive call making sure that our problem gets smaller
					System.out.print(s.charAt(n-1) + "");
					return stringReverse(s.substring(0,n-1), n-1);

			}

}
