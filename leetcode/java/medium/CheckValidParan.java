/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
 */

/**
 * Logic :
 * 
 * Since a * can be for both left and right matching, we need to keep a track of open ( .. and ) 
 * Error case - there are more ( than can be mapped - so if this is positive at the end, its an issue
 *   there are more ) than ( and * . So if we hit less than 0 characters to be matched for a ) then its error
 * anytime we find a ( we increment a count for left and right 
 * anytime we get a * we decrement left and inc right - since its possible for it to match ( and ) ..
 * anytime we get a ) we decrement .. if this goes below 0 its false because it means there is no matching ( or * 
 * after every character , keep the max value of ( or 0 
 * Finally check the open number of ( .. if that is > 0 then false
 */

import java.util.Stack;

public class CheckValidParan {
	
	public static void main(String [] args)
	{
		CheckValidParan cvp = new CheckValidParan();
		
		String input = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
		
		//String input = "(((**";
		
		System.out.println(cvp.checkValidString(input));
	}

	
	public boolean checkValidString(String s)
	{
		 if(s == null || s.trim().length() == 0)
	            return true;
	        
	     int size = s.trim().length();
	     
	     
	     int matchLeft = 0;
	     int matchRight = 0;
	     
	     for(int i= 0; i< size; i++)
	     {
	    	switch(s.charAt(i))
	    	{
	    		case '(':
	    			matchLeft ++;
	    			matchRight ++;
	    		break;
	    		case '*':
	    			matchLeft --;
	    			matchRight ++;
	    		break;
	    		case ')':
	    			matchLeft --;
	    			matchRight --;
	    		
	    	}
	    	
	    	if(matchRight < 0)
	    		return false;
	    	
	    	matchLeft = Math.max(matchLeft, 0);
	    	
	     }
	        return matchLeft == 0;
	        
	}
/*public boolean checkValidString(String s) {
        
        // If input is null or empty - return true
        if(s == null || s.trim().length() == 0)
            return true;
        
        int size = s.trim().length();
        
        if(size == 1 && s.charAt(0) != '*')
            return false;
        
        // If first char is ) or last character is ( return false 
        
        if(s.charAt(0) == ')' || s.charAt(size - 1) == '(')
            return false;
        
        
        Stack<Character> stack = new Stack<Character>();
        
        int starCount = 0;
       
        int openCount = 0;
        int closeCount = 0;
        int diff = 0;
               
        for(int i= 0; i< size; i++)
        {
        	switch(s.charAt(i)){
        		case '(': openCount ++;
        		break;
        		case ')' : closeCount ++;
        		break;
        	}
        	
        }
        
        if(openCount > closeCount)
        {
        	diff = openCount - closeCount;
        }
        
      //  System.out.println(diff);
        
        // Put in stack 
        
        // If we get ) and unable to pop - return false
        
        // While popping - check if * or ( .. If * increment a * pointer 
        
        for(int i= 0; i< size; i++)
        {
            Character c = s.charAt(i);
            
            if(c == ')')
            {
                if(stack.isEmpty())
                  return false;
                
                Character d = stack.pop();
                
                if(d == '*')
                    starCount +=2;
                
            }
            else
            {
                stack.push(c);
            }
       
        }
        
        // If the stack is empty at the end - return true 
        
        if(stack.isEmpty())
            return true;
        
        // Now keeping popping from the stack .. If a ( is found, pop and decrement * count 
        // If * count is 0 - return false 
        
       // if(diff > 0)
        //	starCount = starCount * 2;
        
       // System.out.println(starCount);
        
        while(!stack.isEmpty())
        {
          Character d = stack.pop();
          
          System.out.println(starCount);
          
            if(d == '(')
            {
                if (starCount == 0)
                    return false;
                
                if(starCount > 0)
                	starCount --;
                
            }
            else
            {
                starCount ++;
            }
          
        }
        
        // Return true after all the stack is empty 
        
        return true;
   }
	

boolean checkValidString2(String s) {
    int low=0,high=0;
    for(int i=0;i<s.length();++i) {
        if(s.charAt(i)=='('){
            ++low;
            ++high;
        }
        else if(s.charAt(i) == '*') {
            --low;
            ++high;
        }
        else {
            --low;
            --high;
            if(high<0) break;
        }
        if(low<0) low=0;
    }
    return low==0;
}
*/
}
