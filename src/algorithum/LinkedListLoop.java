package algorithum;

import java.util.LinkedList;

public class LinkedListLoop {
	
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5,6,7,8};
		
		LinkedList<ListNode> list = generateLinkedListByArray(array);
		
		if(list.getLast().next == null) {
			System.out.println( "set loop to "+list.peekLast().val+" to"+list.peekFirst().val);
			list.getLast().next = list.getFirst();
		}
		printOutList(list);
		
		LinkedListLoop test = new LinkedListLoop();
		boolean hasCycle = test.hasCycle(list.getFirst());
		
		System.out.println("the list "+(hasCycle ?"has":"hasn't")+" cycle");
	
		
		
	}
	
	private static void printOutList(LinkedList<ListNode> list) {
		StringBuffer sb = new StringBuffer();
		for (ListNode node : list) {
			sb.append(node.val+"(nextVal:"+(node.next != null? node.next.val : "none")+")  ->  ");
		}
		System.out.println(sb.substring(0, sb.toString().length()-4));
		
	}

	private  static LinkedList<ListNode> generateLinkedListByArray(int[] array) {

		LinkedList<ListNode> linkedList = new LinkedList<ListNode>();
		
		for (int intVal : array) {
			ListNode node = new ListNode(intVal);
			linkedList.offer(node);
		}
		
		for(int j=1;j<linkedList.size();j++) {
			linkedList.get(j-1).next = linkedList.get(j);
		}
		
		StringBuffer sb = new StringBuffer();
		for (ListNode node : linkedList) {
			sb.append(node.val+"(nextVal:"+(node.next != null? node.next.val : "none")+")  ->  ");
		}
		System.out.println(sb.substring(0, sb.toString().length()-4));
		
		return linkedList;
	}


	   public boolean hasCycle(ListNode head) {
		   boolean looped = false;
		   
		   ListNode fast = head;
		   ListNode slow = head;
		   
		   while(fast != null && fast.next!= null) {
			   fast = fast.next.next;
			   slow = slow.next;
			   
			   if(fast == slow) {
				   looped = true;
				   break;
			   }
				   
		   }
		   
		   return looped;
	   }
}
