package comp2402a2;
import java.util.List;
import java.util.ArrayList;


/**
 */
public class Tester {
	public static boolean testPart1(List<Integer> ell) {
		int K = 100000;
		Stopwatch s = new Stopwatch();
		System.out.flush();
		/*Appending test*/
		s.start();
		for (int i = 0; i < K; i++) {
			ell.add(i);
		}
		s.stop();
		System.out.println(s.elapsedSeconds());
		System.out.flush();
		/*Setting test*/
		s.start();
		for (int i = 0; i < K; i++) {
			ell.set(i, 0);
		}
		s.stop();
		System.out.println(s.elapsedSeconds());
		System.out.flush();
		/*Getting test*/
		boolean test = true;
		s.start();
		for (int i = 0; i < K; i++) {
			if(ell.get(i) != 0){
				test = false;
			}
		}
		s.stop();
		System.out.println(s.elapsedSeconds());
		System.out.flush();
		/*Prepending test*/
		s.start();
		for (int i = 0; i < K; i++) {
			ell.add(0, i);
		}
		s.stop();
		System.out.println(s.elapsedSeconds());
		/*Midpending test*/
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			ell.add(ell.size()/2, i);
		}
		s.stop();
		System.out.println(s.elapsedSeconds());


		/*Removing from back*/
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			ell.remove(ell.size()-1);
		}
		s.stop();
		System.out.println(s.elapsedSeconds());

		/*Removing from front*/
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			ell.remove(0);
		}
		s.stop();
		System.out.println(s.elapsedSeconds());

		/*Removing from middle*/
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			ell.remove(ell.size()/2);
		}
		s.stop();
		System.out.println(s.elapsedSeconds());
		return (true && test);
	}

	public static boolean testPart2(List<Integer> ell) {
		int K = 100000;
		Stopwatch s = new Stopwatch();
		boolean test = true;
		/*Appending*/
		System.out.print("Appending " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			ell.add(i);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		/*Setting*/
		System.out.print("Setting " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			ell.set(i, 0);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		/*Getting*/
		System.out.print("Getting " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			if(ell.get(i) != 0){
				test = false;
			}
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		/*Prepending*/
		System.out.print("Prepending " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			ell.add(0, i);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		/*Removing from back*/
		System.out.print("Removing " + K + " items from the back...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			ell.remove(ell.size()-1);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		/*Removing from front*/
		System.out.print("Removing " + K + " items from the front...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			ell.remove(0);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");
		return (true && test);
	}

	public static boolean testPart3(Table<Integer> t) {
		Stopwatch s = new Stopwatch();
		int rows = 1000;
		int cols = 1000;


		System.out.flush();
		s.start();
		for (int i = 0; i < cols; i++) {
			t.addCol(t.cols());
		}
		s.stop();

		if(s.elapsedSeconds() > 1){
			return false;
		}
		System.out.flush();
		s.start();
		for (int i = 0; i < rows; i++) {
			t.addRow(t.rows());
		}
		s.stop();
		if(s.elapsedSeconds() > 1){
			return false;
		}

		System.out.flush();
		s.start();
		for (int i = 1; i <= rows; i++) {
			t.set(i-1, (i-1)%t.cols(), 1111*i);
		}
		s.stop();
		if(s.elapsedSeconds() > 1){
			return false;
		}

		System.out.flush();
		s.start();
		for (int i = 1; i <= rows; i++) {
			t.get(i-1, (i-1)%t.cols());
		}
		s.stop();
		if(s.elapsedSeconds() > 1){
			return false;
		}

		System.out.flush();
		s.start();
		for(int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				t.get(i, j);
			}
		}
		s.stop();
		if(s.elapsedSeconds() > 1){
			return false;
		}

		System.out.flush();
		s.start();
		for(int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				t.set(i, j, 1234);
			}
		}
		s.stop();
		if(s.elapsedSeconds() > 1){
			return false;
		}

		return true;
	}

}
