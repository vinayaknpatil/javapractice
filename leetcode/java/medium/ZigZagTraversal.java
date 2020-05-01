import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * @author vpatil
 *
 */
public class ZigZagTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root == null)
			return result;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		int counter = 0;
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			Queue<TreeNode> temp = new LinkedList<TreeNode>();
			List<Integer> levelCollection = new ArrayList<>();
			
			while(!queue.isEmpty())
			{
				
				TreeNode node = queue.poll();
				
				if(node.left != null)
                    temp.add(node.left);
                
                if(node.right != null)
    			    temp.add(node.right);
				
				levelCollection.add(node.val);
			
			}
			
			queue = temp;
			
			if(counter % 2 == 1)
				Collections.reverse(levelCollection);

			result.add(levelCollection);
			counter++;
			
		}
	
		return result;
    }
	
}
