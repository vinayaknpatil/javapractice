package javapractice.leetcode.basic;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
	
	public static void main(String [] args)
	{
		TwoSum parse = new TwoSum();
		
		int[] input = {1,3,4,3};
		
		int[] res = parse.twoSum(input, 6);
		
		for(int i:res)
		{
			System.out.print(i);
		}
	}
	
	
    public int[] twoSum(int[] nums, int target) {
        // Basic solution

        int[] result = new int[2];
        
        
        List<Integer> indexHolder = new ArrayList<Integer>();
        
        // Build the mapping 
        
        for(int i=0;i < nums.length; i++)
        {
        	indexHolder.add(nums[i]);
        }	
         
        for(int i =0 ; i<indexHolder.size(); i++)
        {
        	int firstIndex = i;
        	
        	int value = indexHolder.get(i);
        	int remainder = target - value;
        	
        	int secondIndex = indexHolder.lastIndexOf(remainder);
        	
        	if(secondIndex != -1 && firstIndex != secondIndex)
        	{
        		result[0] = firstIndex;
        		result[1] = secondIndex;
        		
        		return result;
        	}
        }
        
        return result;
       
    }
    
}

