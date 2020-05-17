/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
 * @author vpatil
 *
 */
public class OddEvenLinkedList {
	 public ListNode oddEvenList(ListNode head) {
	  
		 if(head == null)
			 return head;
		 
		 
		 ListNode oddEnd = head, evenStart = null, evenEnd = null;
		 
		 ListNode trav = head.next;
		 
		 while(true)
		 {
			 if(trav == null)
				 break;
			 
			 if(evenStart == null) // The first even node - node 2 
			 {
				 evenStart = trav;
				 evenEnd = trav;
				 
				 trav = trav.next;
			 }
			 else
			 {
				 oddEnd.next = trav;
				 oddEnd = trav;
				 
				 // Now handle the even part 
				 evenEnd.next = trav.next;
				 evenEnd = trav.next;
				 
				 if(evenEnd == null)
					 break;
				 
				 trav = evenEnd.next;
			 }
			 
			 
		 }
		 oddEnd.next = evenStart;
		 
		 return head;
		 
	  }
	 
	 
	 public ListNode oddEvenList2(ListNode head) {
	        
			if (head == null)
				return null;

			if (head.next == null) {
				return head;
			}

			ListNode oddHead = head;
			ListNode evenHead = head.next;

			ListNode tmpOddNode = oddHead;
			ListNode tmpEvenNode = evenHead;

			ListNode linkNode = null;
			while (tmpOddNode != null && tmpEvenNode != null) {

				tmpOddNode.next = tmpEvenNode.next;
				if (tmpEvenNode.next != null)
					tmpEvenNode.next = tmpEvenNode.next.next;
				if (tmpOddNode.next == null)
					linkNode = tmpOddNode;
				tmpOddNode = tmpOddNode.next;
				tmpEvenNode = tmpEvenNode.next;
			}

			if (linkNode != null)
				linkNode.next = evenHead;
			else
				tmpOddNode.next = evenHead;

			return oddHead;
		
	    } 
}
