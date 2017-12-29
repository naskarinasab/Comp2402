package comp2402a2;

import java.util.AbstractList;
import java.util.List;

/**
 */
public class Treque<T> extends AbstractList<T> {
 /**
  * You decide on the instance variables you need.
  */
  public ArrayDeque<T> front;
  public ArrayDeque<T> back;

 public Treque(Class<T> t) {
  // Put your own code here
  front = new ArrayDeque<T>(t);
  back = new ArrayDeque<T>(t);
  //throw new UnsupportedOperationException("Constructor not yet implemented");
 }

 public T get(int i) {
   if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
  // Put your own code here instead of throwing this exception
  //throw new UnsupportedOperationException("get(i) not yet implemented");
  if(i < front.size()){
    return front.get(i);
  } else {
    return back.get(i - front.size());
  }
 }

 public T set(int i, T x) {
  if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
  // Put your own code here instead of throwing this exception
  //throw new UnsupportedOperationException("set(i,x) not yet implemented");
  if(i < front.size()){
    return front.set(i, x);
  } else {
    return back.set(i - front.size(), x);
  }
 }

 public void add(int i, T x) {
  if (i < 0 || i > size()) throw new IndexOutOfBoundsException();
  // Put your own code here
  //throw new UnsupportedOperationException("add(i,x) not yet implemented");
  if(i < front.size()){
    front.add(i, x);
  } else {
    back.add(i - front.size(), x);
  }
  balance();
 }

 public T remove(int i) {
  if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
  // Put your own code here
  // throw new UnsupportedOperationException("remove(i) not yet implemented");
  T x;
  if(i < front.size()){
    x = front.remove(i);
  } else {
    x = back.remove(i - front.size());
  }
  balance();
  return x;
 }

 public int size() {
  // Put your own code here
  return front.size() + back.size();
  // throw new UnsupportedOperationException("size() not yet implemented");
 }

public void balance() {
  if(front.size() == back.size()+2){
    back.add(0, front.remove(front.size()-1)); //put the first value of front onto the front of back, then remove that value
  }
  else if(back.size() == front.size()+2){
    front.add(front.size(), back.remove(0)); //put the first value from back onto the end of front, then remove that value
  }
}

	public static void main(String[] args) {
		List<Integer> ell = new Treque<Integer>(Integer.class);
		Tester myTest = new Tester();
		System.out.println("Result: " + myTest.testPart1(ell));
	}



}
