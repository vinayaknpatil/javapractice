import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 * @author vpatil
 *
 */
public class PlusOne {
	
	public static void main(String [] args)
	{
		PlusOne pOne = new PlusOne();
		
		int[] digits = new int[]{9,9,9};
		
		pOne.plusOne(digits);
		
	}
	
	public int[] plusOne(int[] digits) {
	      
		 if(digits == null || digits.length == 0)
			 return digits;
		 
		 
		 List<Integer> sum = new ArrayList<Integer>();
		 
		 int carryOver = 1;
		 
		 //int digitSum = 0;
		 
		 for(int i = digits.length -1; i>= 0; i--)
		 {
			int digitSum = carryOver+ digits[i];
			 
			
			
			 sum.add(0, digitSum%10);
			 carryOver = digitSum/10;
			 
			// System.out.println("Value "+digitSum%10+ " Carryover "+carryOver);
			 
		 }
		 
		 if(carryOver > 0)
			 sum.add(0, carryOver);
		 
		// System.out.println("Carryover "+carryOver);
		 
		 int[] result = new int[sum.size()];
		 
		 int j = 0;
		 
		 for(Integer data: sum)
		 {
			 result[j++] = data;
		 }
		 
		 return result;
	 }
	
}
