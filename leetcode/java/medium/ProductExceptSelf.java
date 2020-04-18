/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 * @author vpatil
 *
 */
public class ProductExceptSelf {
	
	public static void main(String [] args)
	{
		ProductExceptSelf pes = new ProductExceptSelf();
		int [] nums = new int []{3,2,5,8};
		
		int [] result = pes.productExceptSelf(nums);
		
		for(int i: result)
			System.out.println(i);
	}

	 public int[] productExceptSelf(int[] nums) {
		 
		 // Product at any except itself is the product of all nums before it and all nums after it 
		 
		 int[] temp = new int [nums.length];
		 
		 temp[0] = 1;
		 
		 for(int i = 1; i < nums.length; i++)
		 {
			 temp[i] = temp[i -1] * nums[i-1];
		 }
		 
		 for(int i: temp)
				System.out.println(i);
		 
		 // Now reverse the process by multiplying the results 
		 int val = 1;
			 
		 for(int i = nums.length-1; i >= 0; i--)
		 {
			 temp[i] = temp[i] * val;
			 val = val * nums[i];
			 
		 }
		 
		 return temp;
	    }
	
}
