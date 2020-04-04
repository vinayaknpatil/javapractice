/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 * @author vpatil
 *
 */
public class MaximumSubArray {

public int maxSubArray(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return 0;
        
        int currentMax = nums[0];
        int maxSoFar = nums[0];
        
        for(int i = 1; i< nums.length; i++)
        {
            currentMax = Math.max(nums[i], currentMax+nums[i]);
            maxSoFar = Math.max(currentMax, maxSoFar);
        }
        
        return maxSoFar;
        
    }
	
}
