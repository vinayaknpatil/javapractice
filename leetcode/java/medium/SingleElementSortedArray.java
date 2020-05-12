/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

 

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
 

Note: Your solution should run in O(log n) time and O(1) space.
 * @author vpatil
 *
 */

public class SingleElementSortedArray {
	public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        
        int start = 0;
        int end = nums.length -1;
        
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            
            // If mid is the number 
            
            if(mid == 0 || mid == nums.length -1) // corner case
                return nums[mid];
            
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];
            
            
            if(mid%2 == 0) 
            {
                // Even index , odd number in the array. If this is same as the previous element, then the target is on the left side. Else right side 
                
                if(nums[mid] == nums[mid-1])
                {
                    end = mid -1;
                }
                else
                {
                    start = mid + 1;
                }
                
            }
            else
            {
                // Odd index , even number in the array. If this is same as the previous element, then the target is on the right side. Else left side 
                
                if(nums[mid] == nums[mid-1])
                {
                    start = mid+1;
                }
                else
                {
                    end = mid - 1;
                }
                
            }
            
           
            
        }
        
         return -1;
    }
}
