/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 * @author vpatil
 *
 */
public class CanJump {
	
	public static void main(String [] args)
	{
		CanJump canJump = new CanJump();
		
		//int [] input = new int []{2,3,1,1,4};
		int [] input = new int []{2,3,1,1,4};
		System.out.println(canJump.canJump(input));
	}
	
public boolean canJump(int[] nums) {
        
		if(nums == null || nums.length == 0)
			return false;
		
		if(nums.length == 1)
			return true; // Only one element - already at last 
	
		
		int targetIndex = nums.length - 1;
		
		for(int i = nums.length - 2; i >= 0; i--)
		{
			if(nums[i] != 0 && nums[i]+i >= targetIndex)
			{
				targetIndex = i;
			}
		}
		
		return (targetIndex == 0);
		
    }
}
