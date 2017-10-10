package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

public class Part6 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		/*
		Read all of the input lines and output them sorted by length, with ties being broken by the usual sorted order.
		Duplicate lines should be printed only once. Take special care so that a file with a lot of duplicate
		lines does not use more memory than what is required for the number of unique lines.
		*/
		List<String> s = new ArrayList<String>();
		Set<String> hs = new HashSet<String>();
		for (String line = r.readLine(); line != null; line = r.readLine()) {
			s.add(line);
		}
		hs.addAll(s); 
		s.clear();
		s.addAll(hs);
		Collections.sort(s, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() != s2.length()){
					return s1.length() - s2.length();
				}
				return s1.compareTo(s2);
			}
		});

		for(String text : s){
			w.println(text);
		}
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
