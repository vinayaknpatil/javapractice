/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.

If there're duplicates in arr, count them seperately.

 

Example 1:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
Example 2:

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
Example 3:

Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
Example 4:

Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.
 */
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.HashSet;

public class CountingElements {
	
	public static void main (String [] args)
	{
		CountingElements elements = new CountingElements();
		int [] input = new int []{2,2,1,1};
		
		System.out.println(elements.countElements(input));
	}

	public int countElements(int[] arr) {
        
        
        int count = 0;
        
        if(arr == null || arr.length == 0)
            return count;
        
        // Put the ints and their counts in a map 
        
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        
        for(int i= 0; i < arr.length; i++)
        {
            if(countMap.get(arr[i]) == null)
            {
                countMap.put(arr[i], 1);
            }
            else
            {
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            }
        }
              
      //  System.out.println(countMap);
        
        // Loop thru the map
        
        /*for(Integer k: countMap.keySet())
        {
            Integer keyCount = countMap.get(k);
        // For each element, get the +1     
            Integer nextNum = countMap.get(k+1);
            
            // Get the min of their counts 
            if(nextNum != null)
            {
                // Add to the total sum 
                count += keyCount;
            }
        }*/
        
        for(Entry<Integer,Integer> entrySet : countMap.entrySet()) {
            int key = entrySet.getKey();           
            if(countMap.containsKey(key+1)) {
                count=count+entrySet.getValue();
            }
        }
        
       return count; 
        
    }
	
	
	public int countElementsUsingSet(int[] arr) {
        int count =0;
        if(arr.length==1)
            return count;
	        HashSet<Integer> mSet = new HashSet<Integer>();
	        for(int i=0; i<arr.length ; i++) {
	           mSet.add(arr[i]);            
	        }        
	        for(int i=0 ; i<arr.length ;i++) {
	           if(mSet.contains(arr[i]+1)) {
	        	   count++;
	           }
	        }
	        return count;
    }
	
}
