package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Part10 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		/*
		Read the entire input one line at a time and then output a subsequence of the lines that appear in
		the same order they do in the file and that are also in non-decreasing or non-increasing sorted order.
		If the file contains n lines, then the length of this subsequence should be at least sqrt(n).
		For example, if the input contains 9 lines with the numbers 2, 1, 3, 7, 4, 6, 9, 5, 8 then your output should have at least 3 lines,
		which could be 1,3,4 (increasing) or 2,3,7 (increasing) or 1,4,6,9 (increasing)  or 2,6,8 (increasing) or
		7,6,5 (decreasing) or ...).
		Warning/Hint: This is probably the hardest question. You're being asked to implement the Erdős–Szekeres theorem.
		*/
	}

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 10e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
