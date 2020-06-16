import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

	List<Integer> result;
	int[] subsetSize;
	
	public List<Integer> largestDivisibleSubset(int[] nums) {
        
		if(nums == null || nums.length == 0)
			return new ArrayList<Integer>();
		
		Arrays.sort(nums);
		subsetSize = new int[nums.length];
		Arrays.fill(subsetSize, -1);
		result = new ArrayList<>();
		getDivSubset(nums,0, new ArrayList<>(), 1);
		
		return result;
		
    }
	
	void getDivSubset(int[] nums, int index, ArrayList curr, int prev )
	{
		if(curr.size() > result.size())
			result = new ArrayList<>(curr);
		
		for(int i = index; i< nums.length; i++)
		{
			if(curr.size() > subsetSize[i] && nums[i] % prev == 0)
			{
				subsetSize[i] = curr.size();
				curr.add(nums[i]);
				getDivSubset(nums, i+1, curr, nums[i]);
				curr.remove(curr.size() - 1);
			}
		}
	}
}
