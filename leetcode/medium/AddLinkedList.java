/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  **/

public class AddLinkedList {
	
	public static void main(String [] args)
	{
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(7);
		ListNode n3 = new ListNode(9);
		
		n1.next = n2;
		n2.next = n3;
		
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(8);
		
		n4.next = n5;
		
		
		Solution s = new Solution();
		ListNode result = s.addTwoNumbers(n1, n4);
		
		parseAndPrint(result);
		
	}
	
	public static void parseAndPrint(ListNode node)
	{
		while(true)
		{
			if(node ==null)
				break;
			
			System.out.print(node.val+"--");
			
			node = node.next;
		}
	}
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	  
		 int carryOver = 0;
		
		 // Loop thru each link
		 
		 ListNode result = null;
		 
		 ListNode temp = null;
		 
		 int sum = 0;
		 
		 while(l1 != null || l2 != null)
		 {
			 int l1Num = 0;
			 int l2Num = 0;
			 
			 if(l1 != null)
			 {
				 l1Num = l1.val;
				 l1 = l1.next;
			 }
			 
			 if(l2 != null)
			 {
				 l2Num = l2.val;
				 l2 = l2.next;
			 }
			 
			 sum = carryOver + l1Num + l2Num;
			 
			 carryOver = sum / 10;
			 
			 ListNode node = new ListNode(sum % 10);
			 
			 if(result == null)
			 {
				 result = node;
				 temp = node;
			 }
			 else
			 {
				 temp.next = node;
				 temp = node;
			 }
			 
		 }
		 
		 if(carryOver > 0)
		 {
			 ListNode carryNode = new ListNode(carryOver);
			 temp.next = carryNode;
		 }
		 // Find out the sum , have a carry over in case 
		 
		 // create output links 
		 return result;
	 }
}


class ListNode
{
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
