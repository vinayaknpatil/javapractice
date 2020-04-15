/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 * @author vpatil
 *
 */
public class RotatedArraySearch {

	public static void main(String [] args)
	{
		RotatedArraySearch ras = new RotatedArraySearch();
		int [] nums = new int []{1,2,3,4,5,6,7,0};
		int target  = 5;
		
		System.out.println(ras.search(nums, target));
	}
	
	
public int search(int[] nums, int target) {
        
        int index = -1;
        
        if(nums == null || nums.length == 0 )
            return index;
        
        
         int start = 0;
         int end = nums.length -1;
        
        while(start <= end)
        {
            int mid = (start+end)/2;
            
            if(nums[mid] == target)
            {
               return mid;
            }
            
            // If the first part of the array is sorted 
            
            if(nums[start] <= nums[mid])
            {
            	if(target >= nums[start] && target <= nums[mid])
            	{
            		end = mid - 1;
            	}
            	else
            	{
            		start = mid + 1;
            	}
            }
            else // Second part of array is sorted
            {
            	if(target >= nums[mid] && target <= nums[end])
            	{
            		start = mid + 1;
            	}
            	else
            	{
            		end = mid - 1;
            	}
            }
               
        }
        
        return index;
        
    }
	
	
/*public int search(int[] nums, int target) {
        
        int index = -1;
        
        if(nums == null || nums.length == 0 )
            return index;
        
        
         int start = 0;
         int end = nums.length -1;
        
        while(start <= end)
        {
            int mid = (start+end)/2;
            
            if(nums[mid] == target)
            {
                index = mid;
                break;
            }
            else if(nums[mid] > target)
            {
                // Usually we would have gone to the left side. But need to compare target against the start 
                
                if(nums[start] > target)
                {
                    start = mid+1;
                }
                else
                {
                    end = mid -1;
                }
            }
            else
            {
                // we would have gone to the right side 
                if(nums[end] < target )
                {
                    end = mid -1;
                }
                else
                {
                    start = mid +1;
                }
            }
            
            
        }
        
        return index;
        
    }*/
}

