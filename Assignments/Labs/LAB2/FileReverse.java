import java.io.*;
import java.util.Scanner;

class FileReverse{
	public static void main(String[] args) throws IOException{

		Scanner in = null;
		PrintWriter out = null;
		String line = null;
		String[] token = null;
		int i, n, lineNumber = 0;

		//check command line arguments
		if(args.length < 2){
			System.out.println("Usage: FileTokens infile outfile");
			System.exit(1);
		}

		//open files
		in = new Scanner(new File(args[0]));
		out = new PrintWriter(new FileWriter(args[1]));

		//read lines from in, extract and print tokens from each line
		while( in.hasNextLine() ){
			lineNumber++;

			//trim leading and trailing spaces, then add one trailing space so
			//split works on blank lines
			line = in.nextLine().trim() + " ";

			//split line around white space
			token = line.split("\\s+");

			//call method that prints out tokens in reverse
			n = token.length;
			//out.println("Line " + lineNumber + " contains " + n + "tokens:");
			for(i=0; i<n; i++) {
				//out.println("  "+token[i]);
				out.println(stringReverse(token[i], token[i].length()));
			}
		}
		//close files
		in.close();
		out.close();
	}

		public static String stringReverse(String s, int n) {
			if (n <= 1) {
				return s;
			} n--;
				return stringReverse((s.substring(1)), n) + s.charAt(0);
			}
}
