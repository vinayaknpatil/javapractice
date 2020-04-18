/**
 * Given a binary search tree, return a balanced binary search tree with the same node values.

A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

If there is more than one answer, return any of them.

 

Example 1:



Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.
 

Constraints:

The number of nodes in the tree is between 1 and 10^4.
The tree nodes will have distinct values between 1 and 10^5.
 */
import java.util.ArrayList;

public class BalanceBST {
	
	public static void main(String [] args)
	{
		BalanceBST bst = new BalanceBST();
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		
		n1.right = n2;
		n2.right = n3;
		n3.right = n4;
		
		bst.balanceBST(n1);
		
	}
	

	 public TreeNode balanceBST(TreeNode root) {
		 
		// In order traversal
		 
		if(root == null)
			return null;
		
		ArrayList<Integer> nodeList = new ArrayList<>();
		
		parseAndAddNode(root, nodeList);
		
		Integer [] nodeArray = new Integer [nodeList.size()];
		
		nodeList.toArray(nodeArray);
		
		
		// Now generate the tree
		
		if(nodeArray.length == 1)
			return new TreeNode(nodeArray[0]);
		
		TreeNode result = getTree(nodeArray, 0, nodeArray.length);
			 
		return result;
		
	}
	
	private TreeNode  getTree(Integer [] array, int start, int end)
	{
		//System.out.println("Start "+start+ " end "+end);
		
		if(start > end)
			return null;
		
		int mid = (start + end )/2;
		
		if(mid > array.length - 1 || mid < 0)
			return null;
		
		//System.out.println("Node point "+array[mid]);
		
		TreeNode node = new TreeNode(array[mid]);
		
		// get left and right 
		
		//System.out.println("Left of "+array[mid]);
		 TreeNode left = getTree(array, start, mid-1);
		 
		// System.out.println("Right of "+array[mid]);
		 TreeNode right = getTree(array, mid+1, end);
		 
		 node.left = left;
		 node.right = right;
		 
		 return node;
			
	}
	 
	
	private void parseAndAddNode (TreeNode node, ArrayList<Integer> nodeList)
	{
		if(node == null)
			return;
		
		parseAndAddNode(node.left, nodeList);
		nodeList.add(node.val);
		parseAndAddNode(node.right, nodeList);
	}
	 
	
}
