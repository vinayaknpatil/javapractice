/**
 * You are given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
Example 4:

Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"

Constraints:

0 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It's guaranteed that all parentheses are balanced.
 */

import java.util.Stack;

public class ReverseParantheses {

	public static void main(String [] args)
	{
		ReverseParantheses rp = new ReverseParantheses();
		
		System.out.println(rp.reverseParentheses("a(bcdefghijkl(mno)p)q"));
	}
	
	
public String reverseParentheses(String s) {
        
        if(s == null || s.length() == 0)
            return s;
        
        
        StringBuffer ans = new StringBuffer();
        
        
        Stack<Character> letterStack = new Stack<Character>();
        
        for(int i = 0; i< s.length() ; i++)
        {
         
            char c = s.charAt(i);
            
            letterStack.push(c);
            
            if(c == ')')
            {
            	letterStack.pop();
                StringBuffer buf = new StringBuffer();
                
                while(!letterStack.isEmpty())
                {
                    char pop = letterStack.pop();
                    if(pop == '(')
                        break;
                    
                    buf.append(pop);
                }
                
                //ans = buf;
                
                for(int j = 0 ; j < buf.length(); j++)
                {
                    letterStack.push(buf.charAt(j));
                }
            }
        
        }
        
        for(Character c: letterStack)
        {
        	ans.append(c);
        }
        
       return ans.toString(); 
    }
	
}

