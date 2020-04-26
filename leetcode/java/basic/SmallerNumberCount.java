import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallerNumberCount {

	public int[] smallerNumbersThanCurrent(int[] nums) {
        
    if(nums == null || nums.length == 0)
    	return null;
    
    int [] result = new int[nums.length];
    
    List<Integer> arrayList = new ArrayList<>();
    
    for(int i = 0 ; i < nums.length;i++)
    {
    	arrayList.add(nums[i]);
    }
    
    Collections.sort(arrayList);
    
    int length = nums.length;
    
    for(int i = 0; i < length ; i++)
    {
    	
    	int index = arrayList.indexOf(nums[i]);
    	result[i] = index;
    	
    }
    
   /* for(int i = 0 ; i < nums.length;i++)
    {
    	for (int j = 0 ; j < nums.length; j++)
    	{
    		if(nums[j] < nums[i])
    		{
    			result[i] = result[i]+1;
    		}
    	}
    }
   */     
    return result;
   }
}
