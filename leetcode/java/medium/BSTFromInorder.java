/**
 * Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 * @author vpatil
 *
 */
public class BSTFromInorder {
	
	public TreeNode bstFromPreorder(int[] preorder) {
		
		if(preorder == null || preorder.length == 0)
			return null;
		
		
		TreeNode root = new TreeNode(preorder[0]);
			
		for(int i = 1 ; i < preorder.length; i++ )
		{
			addNode(root, preorder[i]);
		}
		
		return root;
    }

	private void addNode(TreeNode node, int i) {
				
		if(i< node.val)
		{
			if(node.left == null)
			{
				TreeNode child = new TreeNode(i);
				node.left = child;
				return;
			}
			
			addNode(node.left, i);
			
		}
		else
		{
			if(node.right == null)
			{
				TreeNode child = new TreeNode(i);
				node.right = child;
				return;
			}
			
			addNode(node.right, i);
		}
	
	}
}


class Solution {
    int preIndex =0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder,Integer.MAX_VALUE); 
    }

    TreeNode constructBST(int[] preOrder,int val){
        if (preIndex==preOrder.length || val<preOrder[preIndex])
            return null;
        TreeNode root=new TreeNode(preOrder[preIndex++]);
        root.left=constructBST(preOrder,root.val);
        root.right=constructBST(preOrder,val);
        return root;
    }
}
