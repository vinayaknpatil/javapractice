/**
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
 */

import java.util.Random;

public class RandomPickWeight {	

	int[] lookup;
	int maxSize = 0;
	Random random = new Random();
	
	
	public static void main(String [] args)
	{
		int [] wt = new int []{1,3};
		RandomPickWeight rw = new RandomPickWeight(wt);
		
		for (int i=0 ; i< 5; i++)
			System.out.println(rw.pickIndex());
	}
	
	public RandomPickWeight(int[] w) {
		lookup = new int[w.length];
		
		for(int i=0; i< w.length; i++)
		{
			maxSize += w[i];
			lookup[i] = maxSize;
			
		}
		
    }
    
    public int pickIndex() {
     
    	int index = -1;
    	
    	int number = random.nextInt(maxSize);
    	
    	int left =0, right = lookup.length-1;
    	
    	System.out.println("Number" +number);
    	
    	while(left <= right)
    	{
    		int mid = left + (right-left)/2;
    		
    		if(number < lookup[mid])
    		{
    			index = mid;
    			
    			right = mid -1;
    		}
    		else
    		{
    			left = mid+1;
    		}
    		
    	}
    	
    	return index;
    	
    }
}
