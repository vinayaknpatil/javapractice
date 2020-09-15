import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * @author vpatil
 *
 */

public class TopKFrequent {
	
	public static void main(String [] args)
	{
		TopKFrequent tfk = new TopKFrequent();
		
		int [] input = new int [] {1};
		
		List<Integer> result = tfk.topKFrequent(input, 1);
		
		for(Integer i: result)
		{
			System.out.println(i);
		}
	}

public List<Integer> topKFrequent(int[] nums, int k) {
        
	Map<Integer,Integer> map = new HashMap<Integer, Integer>();
	
	List<Integer> result = new ArrayList<Integer>();
	
	for(int number: nums)
	{
		
		map.put(number, map.getOrDefault(number, 0)+1);
		
		/*if(map.get(number) == null)
		{
			map.put(number, 1);
		}
		else
		{
			map.put(number, map.get(number)+1);
		}
		*/
	}
	
	PriorityQueue<Pair> pairQueue = new PriorityQueue<>(new Comparator<Pair>() {

		@Override
		public int compare(Pair o1, Pair o2) {
			// TODO Auto-generated method stub
			return o1.frequency.compareTo(o2.frequency);
		}
		
	});
	
	
	for(Integer key: map.keySet())
	{
		pairQueue.add(new Pair(key, map.get(key)));
		
		if(pairQueue.size() > k)
		{
			pairQueue.poll();
		}
	}
	
	for(Pair pq: pairQueue)
	{
		result.add(pq.number);
	}
	
	return result;
		
    }
	
	
}

class Pair
{
	Integer number;
	Integer frequency;
	
	Pair(Integer number, Integer frequency)
	{
		this.number = number;
		this.frequency = frequency;
	}
}
