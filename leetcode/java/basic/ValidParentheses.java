/**
  Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
**/

import java.util.Stack;

public class ValidParentheses {
	
	public static void main(String [] args)
	{
		ValidParentheses vp = new ValidParentheses();
		System.out.println("Input () - is valid "+vp.isValid("()"));
		System.out.println("Input ()[]{}) - is valid "+vp.isValid("()[]{}"));
		System.out.println("Input (] - is valid "+vp.isValid("(]"));
		System.out.println("Input ([)] - is valid "+vp.isValid("([)]"));
		System.out.println("Input {[]} - is valid "+vp.isValid("{[]}"));
		System.out.println("Input {[] - is valid "+vp.isValid("{[]"));
		System.out.println("Input null - is valid "+vp.isValid(null));
		System.out.println("Input empty  - is valid "+vp.isValid(" "));
		System.out.println("Input (( - is valid "+vp.isValid("(("));
		
		System.out.println("Input ){ is valid "+vp.isValid("){"));
	}
	
	
public boolean isValid(String s) {
        
		if(s==null || s.trim().length() == 0)
			return true;
	
		
		if( ( s.length() % 2) != 0)
			return false;
		
		Stack<Character> paraStack = new Stack<Character>();
		
		for(int i=0;i<s.length();i++)
		{
			Character c = s.charAt(i);
			switch (c)
			{
				case '(': paraStack.push(c);
				break;
				case '{': paraStack.push(c);
				break;
				case '[': paraStack.push(c);
				break;
				case ')':
				{
					if( ! isValidCloseParan(paraStack, ')', '('))
						return false;
					paraStack.pop();
					
				}
				break;
				case '}':
				{
					if( ! isValidCloseParan(paraStack, '}', '{'))
						return false;
					paraStack.pop();
				}
				break;
				case ']':
				{
					if( ! isValidCloseParan(paraStack, ']', '['))
						return false;
					paraStack.pop();
				}
				break;
			}
		}
		
		if(paraStack.size() > 0)
			return false;
		
		return true;
		
    }

	boolean isValidCloseParan(Stack<Character> paraStack, Character input, Character match)
	{
		if(paraStack.size() == 0)
			return false;
		Character popped = paraStack.peek();
		if(popped == null || popped != match)
			return false;
		
		return true;
	}

}
