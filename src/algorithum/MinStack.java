package algorithum;

/**
	Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
	
	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.
	
	
	Example:
	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	minStack.getMin();   --> Returns -3.
	minStack.pop();
	minStack.top();      --> Returns 0.
	minStack.getMin();   --> Returns -2.
	
 */
public class MinStack {

	class Node {
		int value;
		int min;
		Node next;

		Node(int x, int min) {
			this.value = x;
			this.min = min;
			next = null;
		}
	}

	Node head;

	public void push(int x) {
		if (null == head) {
			head = new Node(x, x);
		} else {
			Node n = new Node(x, Math.min(x, head.min));
			n.next = head;
			head = n;
		}
	}

	public void pop() {
		if (head != null)
			head = head.next;
	}

	public int top() {
		if (head != null)
			return head.value;
		return -1;
	}

	public int getMin() {
		if (null != head)
			return head.min;
		return -1;
	}

	public static void main(String[] args) {

		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(10);
		obj.push(0);
		obj.pop();
		System.out.println("Stack top is:"+obj.top());
		System.out.println("Stack Min value is: "+ obj.getMin());

	}
}
