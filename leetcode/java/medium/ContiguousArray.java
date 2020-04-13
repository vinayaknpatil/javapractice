/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.

So we keep adding numbers - if 1 add 1 and 0 subtract 1
so if we get 0 thats a whole subset
get the index + 1
else say we get sum as 3
we store the index where the sum first occured
so if after n numbers - we again get 3
it means there are equal number of 0s and 1s
so now do minus of i and that index

 */


import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	
	public static void main(String [] args)
	{
		ContiguousArray cArray = new ContiguousArray();
		int [] input = new int []
				{0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1};			
		
		System.out.println(cArray.findMaxLength(input));
	}
	

public int findMaxLength(int[] nums) {
        
	if(nums == null || nums.length <= 1)
        return 0;
    
	Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    
    int maxWindow = 0;
   
    int sum = 0;
    
    for(int i =0 ; i < nums.length; i++)
    {
      if(nums[i] == 0) 
    	  sum --;
      else
    	  sum ++;
      
      
      if(sum == 0 )
    	  maxWindow = i+1;
      
      if(!hashMap.containsKey(sum))
    	  hashMap.put(sum, i);
      else
    	  maxWindow = Math.max(maxWindow, i - hashMap.get(sum));
      
    }
    
    return maxWindow;
        
   }
	
}
