/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

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
import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {

	public static void main(String [] args)
	{
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.push(-3);
		System.out.println(minStack.getMin());   //--> Returns -3.
		minStack.pop();
		System.out.println(minStack.top());      //--> Returns 0.
		System.out.println(minStack.getMin());   // --> Returns -2.
	}
	
	
	Stack<Integer> myStack; 
	PriorityQueue<Integer> queue; 

	public MinStack() {
		
		this.myStack = new Stack<>();
		this.queue = new PriorityQueue<>();
    }
    
    public void push(int x) {
    	
    	myStack.push(x);
    	queue.add(x);
    }
    
    public void pop() {
        
    	if(!myStack.isEmpty())
    	{
    		int val = myStack.pop();
    		queue.remove(val);
    	}
    	
    }
    
    public int top() {
        if(!myStack.isEmpty())
        	return myStack.peek();
    	
        return Integer.MIN_VALUE;
    }
    
    public int getMin() {
    	if(!queue.isEmpty())
        	return queue.peek();
    	
    	return Integer.MIN_VALUE;
    }
	
}
