/**
 * Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
 * @author vpatil
 *
 */
public class SquareRoot {
	
	public static void main(String [] args)
	{
		SquareRoot sqr = new SquareRoot();
		System.out.println(sqr.mySqrt(Integer.MAX_VALUE));
	}

	public int mySqrt(int x) {
        
        if(x < 2)
        	return x;
		
		long square = 1;
        
		long start = 1;
		
		long end = x/2;
        
		int result = 0;
		
		while(start <= end)
		{			
			long index = (start+end)/2;
			
			square = index * index;
			
			if(square == x)
				return (int)index;
			
			if(square < x) // Need to increase the value 
			{
				start = index + 1;
				result = (int)index;
			}
			else
			{
				end = index -1;
			}
			
		}
       
		return result;
    }
}
