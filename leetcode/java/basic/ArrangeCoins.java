/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
 * @author vpatil
 *
 */
public class ArrangeCoins {
	
	public int arrangeCoins(int n) {
		
		long start = 0, end = n;
		
		long value = 0;
		
		long index = 0;
		
		
		while(start <= end)
		{
			
			index = start + (end - start)/2;
			
			value = index * (index+1)/2;
			
			if(value == n)
				return (int)index;
			
			if(value < n)
			{
			 start = index+1;
			}
			else
			  end = index -1;	
			
		}
		
		return (int)end;
		
		
    }
}
