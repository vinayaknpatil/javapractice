/***
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * @author vpatil
 *
 */
public class RemoveDuplicates {

	public static void main(String [] args)
	{
		RemoveDuplicates dups = new RemoveDuplicates();
		int [] array = new int []{0,0,1,1,1,2,2,3,3,4};
		int val = dups.removeDuplicates(array);
		System.out.println(val);
	}
	
public int removeDuplicates(int[] nums) {
        
		int prevNum = Integer.MIN_VALUE;
		int uniqueCount = 0;
		int index = 0;
		
		
		// Basic use case
		if(nums == null || nums.length == 0)
			return 0;
	
		
		
		for(int i = 0; i< nums.length; i++)
		{
			int num = nums[i];
			
			if(num != prevNum)
			{
				nums[index] = num;
				index ++;
				uniqueCount ++;
				prevNum = num;
			}
		}
	
		return uniqueCount;
    }
	
}
