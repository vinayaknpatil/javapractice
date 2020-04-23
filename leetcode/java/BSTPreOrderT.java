/**
 * Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Note: 

1 <= preorder.length <= 100
The values of preorder are distinct.
 * @author vpatil
 *
 */
public class BSTPreOrderT {
	
	public static void main(String [] args)
	{
		BSTPreOrderT bst = new BSTPreOrderT();
		int [] array = new int []{8,5,1,7,10,12};
		TreeNode result = bst.bstFromPreorder(array);
		
		System.out.println("Done");
	}
	
	public TreeNode bstFromPreorder(int[] preorder) {
		
		if(preorder == null || preorder.length == 0)
			return null;
		
		
		TreeNode node = null;
		
		for(int i = 0; i< preorder.length; i++)
		{
			node = populateNode(node, preorder[i]);
		}
		
		return node;
		
    }
	
	private TreeNode populateNode(TreeNode node, int num)
	{
		if(node == null) // Root node
		{
			node = new TreeNode(num);
		}
		else
		{
			if(num < node.val) // Left side 
			{
				if(node.left == null)
				{
					TreeNode lN = new TreeNode(num);
					node.left = lN;
					
				}
				else
				{
					populateNode(node.left, num);
				}
			}
			else
			{
				if(node.right == null)
				{
					TreeNode rN = new TreeNode(num);
					node.right = rN;
					
				}
				else
				{
					populateNode(node.right, num);
				}
			}
		
		}
		
		return node;
	}

}
