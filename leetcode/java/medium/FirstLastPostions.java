
/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].
 * @author vpatil
 *
 */
public class FirstLastPostions {
	
	public static void main(String []årgs)
	{
		FirstLastPostions flp = new FirstLastPostions();
		
		// 1. Empty array 
		
		int [] test1 = null;
		print(flp.searchRange(test1, 8));
		
		
		int [] test2 = new int[1];
		print(flp.searchRange(test2, 8));
		
		// 2. One element not match 
		int [] test3 = new int[]{8};
		print(flp.searchRange(test3, 6));
		print(flp.searchRange(test3, 8));
		
		// 2 elements - 1 and 2 
		int [] test4 = new int[]{1,2};
		print(flp.searchRange(test4, 6));
		print(flp.searchRange(test4, 1));
		print(flp.searchRange(test4, 2));
		// Multiple - target is 1st 
		int [] test5 = new int[]{1,2,2,5,6,7,7,8,9,10};
		print(flp.searchRange(test5, 1));
		print(flp.searchRange(test5, 9));
		print(flp.searchRange(test5, 10));
		// Multiple - target is last 
		
		// Multiple - target is once 
		
// Multiple - target is multiple times 
		print(flp.searchRange(test5, 2));
		
		// 
	}
	
	private static void print(int [] output)
	{
		for (int i: output)
		{
			System.out.print(i+"##");
		}
		
		System.out.println("\n");
	}
	
	
	public int[] searchRange(int[] nums, int target) {
	      
        int [] notFound = new int[]{-1,-1};
        
      //  int [] single = new int [] {0,0};
        
        if(nums == null || nums.length == 0)
            return notFound;
        
            
        
        int min = 0;
        
        int max = nums.length - 1;
        
        while(min <= max)
        {
            int index = (min + max)/2;
            
            if(nums[index] == target)
            {
                 // Find index indicates that the element is found. Now to check the min and max positions
              int minPos = findMinMaxPositions(nums, min, index, true, target);
                
              int maxPos = findMinMaxPositions(nums, index, max, false, target);
                
                return new int[]{minPos, maxPos};
            }
           else if(nums[index] > target)
                max = index - 1;
            else
                min = index + 1;
        }
        
       
        return notFound;
        
        
    }
    
    
    int findMinMaxPositions(int[] nums, int minIndex, int maxIndex, boolean isMin, int target)
    {
       if(isMin)
        {
            int currentLow = maxIndex;
            
            while(minIndex <= maxIndex)
            {
                int temp = (minIndex + maxIndex)/2;
                
                if(nums[temp] == target)
                {
                    if(temp < currentLow)
                        currentLow = temp;
                    
                    maxIndex = temp - 1;
                    
                }
                else if (nums[temp] > target)
                {
                    maxIndex = temp - 1;
                }
                else
                {
                    minIndex = temp + 1;
                }
                
                
            }
            
            return currentLow;
        }
        else
        {
             int currentHigh = minIndex;
            
            while(minIndex <= maxIndex)
            {
                int temp = (minIndex + maxIndex)/2;
                
                if(nums[temp] == target)
                {
                    if(temp > currentHigh)
                    	currentHigh = temp;
                    
                    minIndex = temp + 1;
                    
                }
                else if (nums[temp] > target)
                {
                    maxIndex = temp - 1;
                }
                else
                {
                    minIndex = temp + 1;
                }
                
                
            }
            
           return currentHigh;
        }
        
        
    }
}

