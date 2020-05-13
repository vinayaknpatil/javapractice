import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * @author vpatil
 *
 */
public class RemoveKDigits {
	
	public static void main(String [] args)
	{
		RemoveKDigits rk = new RemoveKDigits();
		
		String num = "112";
		int k = 1;
		
		System.out.println(rk.removeKdigits2(num, k));
		
	}
	
	public String removeKdigits(String num, int k)
	{
		if(k == 0)
			return num;
		
		if(num == null || num.length() == 0)
			return num;
		
		
		int strLen = num.length();
		
		if(k >= strLen)
			return "0";
		
		
		String minString = num;
		
		StringBuffer result = new StringBuffer(minString);
		
		for(int i = 0; i< k; i++)
		{
			int j = 0;
			
			while(j < result.length() -1 && result.charAt(j) <= result.charAt(j+1))
				j++;
			
			result.delete(j, j+1);
			
		}

		while( result.length() > 0 && result.charAt(0) == '0' )
			result.deleteCharAt(0);
			
		
		if(result.length() == 0)
			return "0";
		
		return result.toString();
	}
	
	
		
	 public String removeKdigits2(String num, int k) {
	        
			if(k == 0)
				return num;
			
			if(num == null || num.length() == 0)
				return num;
			
			
			int strLen = num.length();
			
			if(k == strLen)
				return "0";
			
			Stack<Character> numStack = new Stack<>();
			
			for(int i=0; i< strLen; i++)
			{
				while(!numStack.isEmpty() && numStack.peek() > num.charAt(i) && k > 0)
				{
					numStack.pop();
					k--;
				}
				
				numStack.push(num.charAt(i));
				
			}
			
			while (k > 0)
			{
				numStack.pop();
				k --;
			}
			
			StringBuffer result = new StringBuffer();
			while(!numStack.isEmpty())
				result.append(numStack.pop());
			
			result.reverse();
			
			while(result.length() > 0 && result.charAt(0) == '0')
				result.deleteCharAt(0);
			
			return result.length() == 0 ? "0": result.toString();
			
	    }
	    
}
