import apple.laf.JRSUIUtils.Tree;

/**
 * Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * @author vpatil
 *
 */
public class InvertBinaryTree {
	
 public TreeNode invertTree(TreeNode root) {
	 
	 invertNode(root);
	 
	 return root;
  }
	
 private void invertNode(TreeNode node)
 {
	 if(node == null)
		 return;
	 
	 TreeNode temp =  node.left;
	 node.left = node.right;
	 node.right = temp;
	 
	 invertNode(node.left);
	 invertNode(node.right); 
	
 }
 
}
