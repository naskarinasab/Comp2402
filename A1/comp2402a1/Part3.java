package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.ArrayDeque;


public class Part3 {

    /**
     * Your code goes here - see Part0 for an example
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException
     */
    public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
      /*
      Read the input one line at a time and, if the line numbered i is empty and i≥42,
      then output the line numbered i-42. In this way, the number of lines you output is no
      more than the number of blank lines in the input.
      */
        Deque<String> s = new ArrayDeque<String>();
				for (String line = r.readLine(); line != null; line = r.readLine()) {
          s.add(line);
					if(s.size() == 43){
						if(line.isEmpty()){
							w.println(s.getFirst()); //print first and then remove the first
							s.removeFirst();
              continue;
						}
            s.removeFirst(); //otherwise we no longer need the first one so we remove it
					}
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
