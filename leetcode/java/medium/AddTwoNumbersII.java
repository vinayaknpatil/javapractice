
/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes 
 * first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 */

import java.util.Stack;


public class AddTwoNumbersII {
	
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        Stack<Integer> l1stack = new Stack<Integer>();
        Stack<Integer> l2stack = new Stack<Integer>();

// Dont need this - keep adding the new node as the head 	
        Stack<Integer> resultStack = new Stack<Integer>();
        // Populate the stack 
        
        ListNode result = null;
        ListNode temp = null;
        
        while(true)
        {
            if(l1 == null)
                break;
            
            l1stack.push(l1.val);
            l1 = l1.next;
        }
        
         
        while(true)
        {
            if(l2 == null)
                break;
            
            l2stack.push(l2.val);
            l2 = l2.next;
        }
        
        int carryOver = 0;
        
        while(!l1stack.isEmpty() || !l2stack.isEmpty())
        {
            int i=0;
            int j = 0;
            
            if(!l1stack.isEmpty())
            {
                i = l1stack.pop();
            }
            
             if(!l2stack.isEmpty())
            {
                j = l2stack.pop();
            }
            
            int sum = i+j+carryOver;
            
            int val = sum % 10;
            
            resultStack.push(val);
            
            carryOver = sum / 10;
            
        }
        
        if(carryOver > 0)
        {
            resultStack.push(carryOver);
        }
        
        // Now build the linked list 
        
        while(!resultStack.isEmpty())
        {
            ListNode node = new ListNode(resultStack.pop());
            
            if(result == null)
            {
                result = node;
                temp = node;
            }
            else
            {
                temp.next =node;
                temp = temp.next;
            }
        }
        
              
        return result;
    }
}
