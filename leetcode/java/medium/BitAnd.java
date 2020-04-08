/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
 * @author vpatil
 *
 */

public class BitAnd {
	
	public static void main(String [] args)
	{
		BitAnd b = new BitAnd();
		//System.out.println(b.rangeBitwiseAnd(5, 12));
		
		System.out.println(b.rangeBitwiseAnd2(0, 2147483647));
		
		//System.out.println(2147483646 & 2147483647);
	}
	
	
public int rangeBitwiseAnd(int m, int n) {
        
        int result = m;
        
        for(int i = m; i<= n; i++)
        {
            result = result & i;
            
            if(result == 0 || i == Integer.MAX_VALUE)
            	return result;
            
        }
        
        return result;
    }

public int rangeBitwiseAnd2(int m, int n) {
    
    while(m < n)
    {
    	n = n & (n-1);
    	
    	System.out.println("value is " +n);
    }
   // System.out.println("value is " +n);
    return m & n;
}

}
