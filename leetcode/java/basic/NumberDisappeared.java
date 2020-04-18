import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 * @author vpatil
 *
 */
public class NumberDisappeared {

	public static void main(String [] args)
	{
		int [] array = new int[]{2,2};
		
		NumberDisappeared nds = new NumberDisappeared();
		
		List<Integer> result = nds.findDisappearedNumbers(array);
		
		for(int i: result)
			System.out.println(i);
	}
	
public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> answer = new ArrayList<Integer>();
        
        if(nums == null || nums.length <2)
            return answer;
        
        
        for(int i= 0; i< nums.length; i++)
        {
            int index = Math.abs(nums[i]);
            
            if(nums[index-1] > 0)
            {
                nums[index-1] = -nums[index-1];
            }
         }
        
        for(int i= 0; i< nums.length; i++)
        {
            if(nums[i] > 0)
                answer.add(i+1);
            
        }
        
        return answer;
    }
	
}
