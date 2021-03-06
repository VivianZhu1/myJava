package algorithum;

import java.util.Stack;

public class ImplementQUseStack {

	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	// Push element x to the back of queue.
	public void push(int x) {
		s1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		peek();
		s2.pop();
	}

	// Get the front element.
	public int peek() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}

		return s2.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}
	
	public static void main(String[] args) {
		ImplementQUseStack myQue = new ImplementQUseStack();
		
		int[] ary = {1,2,3,4,5,6,7,8,9};
		
		for (int i : ary) {
			myQue.push(i);
		}
		
		int val = myQue.peek();
		System.out.println(val);
	}

}
