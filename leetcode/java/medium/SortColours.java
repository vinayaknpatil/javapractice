/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 * @author vpatil
 *
 */
public class SortColours {

	public static void main(String [] args)
	{
		SortColours scl = new SortColours();
		
		int[] nums = new int[]{2,2,0,0,2,0,2,1,0};
		
		scl.sortColors(nums);
		
		for(int i: nums)
			System.out.println(i);
		
	}
	
public void sortColors(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return;
        
        int zeroIndex = 0;
        
        int twoIndex = nums.length - 1;
        
        // Swap the numbers if needed .. 
        
        // We will fill 0s at the start of the array and 2s at the end.
        // Maintain the indexes appropriately 
        
        for(int i = 0 ; i < nums.length; i++)
        {
            if(nums[i] == 0) 
            {
                if(i > zeroIndex)
                    swap(nums, i, zeroIndex);
                
                zeroIndex++;
                
            }
            else if(nums[i] == 2 )
            {
            	// Get the right index for last occurence of two
                while(nums[twoIndex] == 2 && twoIndex > 0)
                    twoIndex --;
                
                if(i < twoIndex)
                {
                  swap(nums,i, twoIndex);
                 
                  twoIndex --;
                    
                  // What if the number which came now is 0. Put it in the right index.
                 if(nums[i] == 0)
                 {
                	 if(i > zeroIndex)
                		 swap(nums,i, zeroIndex);
                    zeroIndex++;
                
                 }
                }
            }
        }
    } 
        void swap(int[] nums, int index1, int index2)
        {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp; 
        }
}
