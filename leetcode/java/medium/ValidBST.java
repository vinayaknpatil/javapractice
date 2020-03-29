/**Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */

public class ValidBST {

	public static void main(String [] args)
	{
		TreeNode n1 = new TreeNode(2147483647);
		TreeNode n2 = new TreeNode(2147483647);
		/*TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(6);
		TreeNode n5 = new TreeNode(20);
		*/
		
		n1.right= n2;
		/*n1.right = n3;
		
		n3.left = n4;
		n3.right = n5;*/
		
		System.out.println(new ValidBST().isValidBST(n1));
	}
	
	
	 public boolean isValidBST(TreeNode root) {
	   
		 if(root == null)
			 return true;
		 
		 if(root.left == null && root.right == null)
			 return true;
		 
		 return isValidBSTTree(root, null, null);
		 
		 
	   }
	 
	 
	 public boolean isValidBSTTree(TreeNode root, Integer min, Integer max)
	 {
		 if(root == null)
			 return true;
		 
		 
		 int val = root.val;
		 
		// System.out.println("Val is "+val+" Min value "+min+ " Max value "+max);
		 
		 if(min != null && val <= min )
			 return false;
		 
		 if(max != null && val >= max)
			 return false;
		 
		 
		// System.out.println("Node is valid");
			 return (isValidBSTTree(root.left, min, root.val) && isValidBSTTree(root.right, root.val, max));
		 
	 }
	
	 
	
}
