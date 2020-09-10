/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 
 * 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
 * @author vpatil
 *
 */
public class CountBits {
	
	public static void main(String [] args)
	{
		CountBits bits = new CountBits();
		
		for(int i: bits.countBits(10))
			System.out.println(i);
	
	}
	
public int[] countBits(int num) {
        
        int[] result = new int[num+1];
        
        for(int i = 0 ; i <= num ;i++)
        {
            if(i%2 == 1)
            {
            	result[i] = result[i-1] + 1;
            }
            else
            {
            	result[i] = result[i/2];
            }
        }
    return result;
        
    }
    
    
}
