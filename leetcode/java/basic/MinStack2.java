import java.util.Stack;

public class Minstack2 {

	public static void main(String [] args)
	{
		Minstack2 minStack = new Minstack2();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		//minStack.push(-3);
		System.out.println(minStack.getMin());   //--> Returns -3.
		minStack.pop();
		System.out.println(minStack.top());      //--> Returns 0.
		System.out.println(minStack.getMin());   // --> Returns -2.
	}
	
	
	Stack<StackNode> myStack; 
	int minValue; 
	
	public Minstack2() {
		
		this.myStack = new Stack<StackNode>();
	}
    
    public void push(int x) {
    	StackNode node = new StackNode(x);
    	
    	if(myStack.isEmpty())
    	{
    		minValue = x;
    		node.minValue = minValue;
    		myStack.push(node);
    		
    	}
    	else
    	{
    		minValue = x < minValue ? x: minValue;
    		node.minValue = minValue;
    		myStack.push(node);
    	}

    }
    
    public void pop() {
        
    	if(!myStack.isEmpty())
    	{
    		myStack.pop();
    		
    		if(myStack.isEmpty())
    			minValue = Integer.MIN_VALUE;
    		else
    			minValue = myStack.peek().minValue;
    		    		
    	}
    	
    }
    
    public int top() {
        if(!myStack.isEmpty())
        	return myStack.peek().value;
    	
        return Integer.MIN_VALUE;
    }
    
    public int getMin() {
    	 if(!myStack.isEmpty())
        	return myStack.peek().minValue;
    	
    	return Integer.MIN_VALUE;
    }
	
}

class StackNode
{
	int value;
	int minValue;
	
	StackNode(int value)
	{
		this.value = value;
	}
}
