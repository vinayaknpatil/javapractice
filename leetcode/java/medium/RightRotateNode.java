/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 * @author vpatil
 *
 */
public class RightRotateNode {
	
	public static void main(String [] args)
	{
		RightRotateNode rrn = new RightRotateNode();
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		
		//ListNode n3 = new ListNode(3);
		//ListNode n4 = new ListNode(4);
		//ListNode n5 = new ListNode(5);
		
		
		n1.next = n2;
		//n2.next = n3;
		//n3.next = n4;
		//n4.next = n5;
		
		printNode(rrn.rotateRight(n1,1001));
		//printNode(rrn.rotateRight(n1,2));
		//printNode(rrn.rotateRight(n1,3));
		//printNode(rrn.rotateRight(n1,4));
		//printNode(rrn.rotateRight(n1,5));
				
	}
	
	private static void printNode(ListNode node)
	{
		
		while(node !=null)
		{
			System.out.print(node.val);
			System.out.print("->");
			node = node.next;
		}
		System.out.print("NULL");
		
		System.out.println("\n");
	}
	
	
	public ListNode rotateRight(ListNode head, int k) {
        
        // Take two pointers 
		
		if(head == null || head.next == null)
			return head;
        
		ListNode start = head;
		
		ListNode inc = head;
		    
        // Keep incrementing one till reached K 
		
		int listCount = 0;
        
		for(int i = 0 ; i < k; i++)
		{
			 // If the null is reached before - then reset it to head 
			
			if(inc == null)
			{
				inc = head;
				break;
			}
			listCount ++;
			inc = inc.next;
		}
		
		//System.out.println("List length "+listCount );
		
		if(listCount < k)
		{
		
			int actualTraverse = k%listCount;
			
			for(int i = 0 ; i < actualTraverse; i++)
			{
				inc = inc.next;
			}
		}
		
		if(inc == null)
			return head;
		
		
         // After k is reached, then start from the beginning using another pointer 
		// Then continue till the end is reached 
		while(inc.next != null)
		{
			inc = inc.next;
			start = start.next;
		}
		
              
        // Store the next 
		// The next should be null 
        
        // The next of the end should become head 
       inc.next = head;
       head = start.next;
       start.next = null;
       
       // Return the new start 
       
       return head;
       
    }

}
