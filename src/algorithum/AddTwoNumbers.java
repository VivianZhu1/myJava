package algorithum;

/**
 *  https://leetcode.com/articles/add-two-numbers/
  
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order and each of their nodes contain a single digit. 
    Add the two numbers and return it as a linked list.
	
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Example:
	
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.
	
 
 */

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(4);
		node4.next=node5;
		node5.next=node6;

		
		AddTwoNumbers solution = new AddTwoNumbers();
		ListNode node = solution.addTwoNumbers(node1, node4);
		
		while(node.next!= null) {
			System.out.print( node.val+"-> ");
			node = node.next;
		}
		System.out.print(node.val);
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    	 ListNode dummyHead = new ListNode(0);
    	    ListNode p = l1, q = l2, curr = dummyHead;
    	    int carry = 0;
    	    while (p != null || q != null) {
    	        int x = (p != null) ? p.val : 0;
    	        int y = (q != null) ? q.val : 0;
    	        int sum = carry + x + y;
    	        carry = sum / 10;
    	        curr.next = new ListNode(sum % 10);
    	        curr = curr.next;
    	        if (p != null) p = p.next;
    	        if (q != null) q = q.next;
    	    }
    	    if (carry > 0) {
    	        curr.next = new ListNode(carry);
    	    }
    	    return dummyHead.next;
    }
}


