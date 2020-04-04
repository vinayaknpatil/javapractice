import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * @author vpatil
 *
 */

public class AverageOfLevels {
public List<Double> averageOfLevels(TreeNode root) {
      
		List<Double> results = new ArrayList<Double>();
		// Get two lists, one for count, other for sum 
	
		List<Integer> levelCounts = new ArrayList<Integer>();
		
		List<Double> levelSum = new ArrayList<Double>();
		
	    // Loop and keep adding the sums to the level and inc the count 
	
		if(root == null)
			return results;
		
		parseAndSum(root, levelCounts, levelSum, 0);
		
		for(int i = 0; i< levelCounts.size(); i++)
		{
			results.add(i, levelSum.get(i) / levelCounts.get(i));
		}
	
	    // Get the average 
	
		return results;
    }
    
	void parseAndSum(TreeNode node, List<Integer> levelCounts, List<Double> levelSum, int level )
	{
		if(node == null)
			return;
		
		int value = node.val;
		
		if(level < levelCounts.size())
		{
			levelCounts.set(level, levelCounts.get(level)+1);
			levelSum.set(level, levelSum.get(level) + value);
		}
		else
		{
			levelCounts.add(1);
			levelSum.add(1.0 * value);
		}
		
		parseAndSum(node.left, levelCounts, levelSum, level+1);
		parseAndSum(node.right, levelCounts, levelSum, level+1);
	}
   
}
