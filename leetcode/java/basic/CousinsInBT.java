import java.util.LinkedList;
import java.util.Queue;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
 
 * @author vpatil
 *
 */
public class CousinsInBT {
	
	public static void main(String [] args)
	{
		
		CousinsInBT cbt = new CousinsInBT();
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		n1.left = n2;
		n1.right = n5;
		n2.left = n3;
		n3.left = n4;
		n5.right = n6;
		
		System.out.println(cbt.isCousins(n1, 3, 6));
	}
	

	 public boolean isCousins(TreeNode root, int x, int y) {
		 if(root == null)
			 return false;
		 
		 Queue<TreeNode> outerQueue = new LinkedList<>();
		 outerQueue.add(root);
		 
		 
		 while(!outerQueue.isEmpty())
		 {
			 Queue<TreeNode> innerQueue = new LinkedList<>();
			 
			 boolean levelFound = false;
			 
			 while(!outerQueue.isEmpty())
			 {
				 boolean childFound = false;
				 
				 TreeNode node = outerQueue.poll();
				 
				 if(node.val == x || node.val == y)
				 {
					 if(levelFound) // we have already found the other at the same level 
						 return true;
					 
					 levelFound = true;
				 }
				 // Check that two numbers do not have the same parent
				 if(node.left != null)
				 {
					 innerQueue.add(node.left);
					 
					 int lChild = node.left.val;
					 
					 if(lChild == x || lChild == y)
						 childFound = true;
				 }
				 if(node.right != null)
				 {
					 innerQueue.add(node.right);
					 
					 int rChild = node.right.val;
					 
					 if(rChild == x || rChild == y)
					 {
						 if(childFound) // We had already found the sibling in the same parent
							 return false;
					 }
				 }
				 
			 }
			 
			 // Now if we have found one number and reached here - means other number is not there - return false
			 
			 if(levelFound)
				 return false;
			 
			 outerQueue = innerQueue;
			 
		 }
		 
		 return false;
		 
	  }
	
}
