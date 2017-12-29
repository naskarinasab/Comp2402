package comp2402a2;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Implements the List<T> interface using two Lists
 * so that insertion/deletions at the front or back of the list
 * are fast.  This can be used as an efficient Deque.
 * @author morin
 *
 * @param <T> the type of data stored in this List
 */
 public class RootishArrayDeque<T> extends AbstractList<T> {
	/**
	 * the front "half" of the deque
	 */
	protected RootishArrayStack<T> front;

	/**
	 * the back "half" of the deque
	 */
	protected RootishArrayStack<T> back;

	protected Class<T> myClass;




	/**
	 * Constructor
	 * @param t0 the class of the objects stored in this list
	 */
	public RootishArrayDeque(Class<T> t) {
		front = new RootishArrayStack<T>(t);
		back = new RootishArrayStack<T>(t);
		myClass = t;

	}

	public T get(int i) {
		if (i < front.size()) {
			return front.get(front.size()-i-1);
		} else {
			return back.get(i-front.size());
		}
	}

	public T set(int i, T x) {
		if (i < front.size()) {
			return front.set(front.size()-i-1, x);

		} else {
			return back.set(i-front.size(), x);
		}
	}

	public void add(int i, T x) {
		if (i < front.size()) { //it's in the front
			front.add(front.size()-i, x);
		} else { //it's in the back
			back.add(i-front.size(), x);
		}
		balance();
	}

	public T remove(int i) {
		T x;
		if (i < front.size()) {
			x = front.remove(front.size()-i-1);
		} else {
			x = back.remove(i-front.size());
		}
		balance();
		return x;
	}

	/**
	 * Rebalance the elements between front and back
	 * if necessary
	 */
	 protected void balance() {
 		int n = size();
 		if (3*front.size() < back.size()) {
 			int s = n/2 - front.size();
 			RootishArrayStack<T> l1 = new RootishArrayStack<T>(myClass);
 			RootishArrayStack<T> l2 = new RootishArrayStack<T>(myClass);
 			l1.addAll(back.subList(0,s));
 			Collections.reverse(l1);
 			l1.addAll(front);
 			l2.addAll(back.subList(s, back.size()));
 			front = l1;
 			back = l2;
 		} else if (3*back.size() < front.size()) {
 			int s = front.size() - n/2;
			RootishArrayStack<T> l1 = new RootishArrayStack<T>(myClass);
 			RootishArrayStack<T> l2 = new RootishArrayStack<T>(myClass);
 			l1.addAll(front.subList(s, front.size()));
 			l2.addAll(front.subList(0, s));
 			Collections.reverse(l2);
 			l2.addAll(back);
 			front = l1;
 			back = l2;
 		}
 	}

	public int size() {
		return front.size() + back.size();
	}


	public static void main(String[] args) {
		List<Integer> ell = new RootishArrayDeque<Integer>(Integer.class);
		Tester myTest = new Tester();
		System.out.println("Result: " + myTest.testPart2(ell));
	}
}
