package gfg;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?


 * @author vpatil
 *
 */
public class RemoveNode {

	public static void main(String [] args)
	{
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next= n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode result = new RemoveNode().removeNthFromEnd(n1, 1);
		
		while(true)
		{
			if(result == null)
				break;
			
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	
public ListNode removeNthFromEnd(ListNode head, int n) {
	
	// Get 2 more nodes 
	
	ListNode startNode = head;
	
	ListNode traceNode = head;
	
	if(n == 0)
		return head;
	
	// First traverse to end of the n 
	
	for (int i = 0; i < n ; i++)
	{
		traceNode = traceNode.next;
	}
	
	if(traceNode == null)
	{
		// remove the first element
		
		return head.next;
	}
	
	
	while(true)
	{
		if(traceNode.next == null)
		{
			startNode.next = startNode.next.next;
			
			break;
			
		}
		
		traceNode = traceNode.next;
		startNode = startNode.next;
		
	}
	
	return head;
	        
    }
}



