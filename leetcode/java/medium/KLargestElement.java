import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class KLargestElement {

	 public int findKthLargest(int[] nums, int k) {
	        
	        if(nums == null || nums.length == 0)
	            return 0;
	        
	        Queue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
	        
	        for(int i: nums)
	        {
	            pQueue.add(i);
	        }
	        
	        
	        for(int i=0 ; i<k-1; i++)
	        {
	            pQueue.poll();   
	        }
	        
	        return pQueue.poll();  
	    }
	 
	 
	 public int findKthLargest2(int[] nums, int k) {
	        
	        if(nums == null || nums.length == 0)
	            return 0;	
	        
	       TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
	       
	       for(int i: nums)
	       {
	    	   map.put(i, map.getOrDefault(i, 0)+1);
	       }
	        
	       
	       for(int i: map.keySet())
	       {
	    	   int num = map.get(i);
	    	   
	    	   if(num >= k)
	    		   return i;
	    	   
	    	   k = k - num;
	    		   
	       }
	       
	       return -1;
	    }
}