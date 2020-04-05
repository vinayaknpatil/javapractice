/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 * @author vpatil
 *
 */
public class MoveZeroes {
	
	public static void main(String [] args)
	{
		int [] input = new int []{0,0,0,0,1};
		
		MoveZeroes mz = new MoveZeroes();
		
		mz.moveZeroes(input);
		
		for(int i: input)
		System.out.println(i);
	}

public void moveZeroes(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return;
        
        int zeroCount = 0;
        
        for(int i= 0; i< nums.length; i++)
        {
            if(nums[i] == 0)
                zeroCount++;
            else
                nums[i-zeroCount] = nums[i]; 
        
        } 
        
        // Now append 0s
        
        for(int j = nums.length - zeroCount ; j < nums.length; j++ )
        {
            nums[j] = 0;
        }
       
    }
}
