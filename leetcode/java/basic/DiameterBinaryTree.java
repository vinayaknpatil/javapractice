/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 * @author vpatil
 *
 */
public class DiameterBinaryTree {

		public static void main(String [] args)
		{
			DiameterBinaryTree dbt = new DiameterBinaryTree();
			
			TreeNode n1 = new TreeNode(1);
			TreeNode n2 = new TreeNode(2);
			TreeNode n3 = new TreeNode(3);
			TreeNode n4 = new TreeNode(4);
			TreeNode n5 = new TreeNode(5);
			TreeNode n6 = new TreeNode(6);
			TreeNode n7 = new TreeNode(7);
			TreeNode n8 = new TreeNode(8);
			TreeNode n9 = new TreeNode(9);
			TreeNode n10 = new TreeNode(10);
			TreeNode n11 = new TreeNode(11);
			TreeNode n12 = new TreeNode(12);
			TreeNode n13 = new TreeNode(13);
			TreeNode n14 = new TreeNode(14);
			TreeNode n15 = new TreeNode(15);
			
			n1.left = n2;
			n1.right= n3;
			n2.left = n4;
			n2.right = n6;
			n3.left = n5;
			n4.left = n7;
			n7.left = n8;
			n8.left = n9;
			n6.left = n10;
			n6.right = n11;
			n10.left = n12;
			n10.right = n13;
			n12.left = n15;
			n11.left = n14;
			
			System.out.println(dbt.diameterOfBinaryTree(n1));
			
		}
	
		int maxDiameter = 0;
		
	    public int diameterOfBinaryTree(TreeNode root) {
	        
	    	//maxDiameter = 0;
	    	
	    	if(root == null || (root.left == null && root.right == null))
	    		return 0;
	    	
	    	getDepth(root);
	    	
	       	return maxDiameter;
	    	
	    }
	    
	    int getDepth(TreeNode node)
	    {
	    	if(node == null)
	    		return -1;
	    	
	    	int leftDepth = getDepth(node.left) + 1;
	    	
	    	int rightDepth = getDepth(node.right) + 1;
	    	
	    	int distAtNode = leftDepth + rightDepth;
	    	
	    //	System.out.println("At node "+node.val+" Left D "+leftDepth+" Right Depth "+rightDepth+" Dist "+distAtNode);
	    	
	    	if(distAtNode > maxDiameter)
	    			maxDiameter = distAtNode;
	    	
	       	return Math.max(leftDepth, rightDepth);
	    	
	    }
	}
