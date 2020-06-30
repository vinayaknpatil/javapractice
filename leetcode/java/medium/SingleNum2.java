import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
 * @author vpatil
 *
 */
public class SingleNum2 {
	public int singleNumber(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for(int i: nums)
        {
            counts.put(i, counts.getOrDefault(i,0)+1);
        }
        
        for(Integer key: counts.keySet())
        {
            if(counts.get(key) == 1)
                return key;
        }
        
        return -1;
    }
	
	public int singleNumber2(int[] arr) {
		 int ones = 0, twos = 0; 
	        int common_bit_mask; 
	          
	        int n = arr.length;
	        
	        for(int i=0; i<n; i++ ) 
	        { 
	            /*"one & arr[i]" gives the bits that are there in 
	            both 'ones' and new element from arr[]. We 
	            add these bits to 'twos' using bitwise OR*/
	            twos = twos | (ones & arr[i]); 
	  
	            /*"one & arr[i]" gives the bits that are 
	            there in both 'ones' and new element from arr[]. 
	            We add these bits to 'twos' using bitwise OR*/
	            ones = ones ^ arr[i]; 
	  
	            /* The common bits are those bits which appear third time 
	            So these bits should not be there in both 'ones' and 'twos'. 
	            common_bit_mask contains all these bits as 0, so that the bits can  
	            be removed from 'ones' and 'twos'*/
	            common_bit_mask = ~(ones & twos); 
	                          
	            /*Remove common bits (the bits that appear third time) from 'ones'*/
	            ones &= common_bit_mask; 
	                          
	            /*Remove common bits (the bits that appear third time) from 'twos'*/
	            twos &= common_bit_mask; 
	        } 
	        return ones; 
	}
}
