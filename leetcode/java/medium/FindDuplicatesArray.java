import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 * @author vpatil
 *
 */

public class FindDuplicatesArray {

	
	public static void main(String [] args)
	{
		FindDuplicatesArray findDup = new FindDuplicatesArray();
		
		int [] array = new int[]{4,3,2,7,8,2,3,1};
		
		for(int i: findDup.findDuplicates(array))
		{
			System.out.println(i);
		}
	}
	
public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> duplicates = new ArrayList<Integer>();
        
        if(nums == null || nums.length < 2)
            return duplicates;
        
        
        for(int i=0; i< nums.length; i++)
        {
            int index = Math.abs(nums[i]) - 1;
            
            if(nums[index] < 0)
                duplicates.add(index+1);
            else
                nums[index] = -nums[index];
        }
        
        return duplicates;
        
    }
}
