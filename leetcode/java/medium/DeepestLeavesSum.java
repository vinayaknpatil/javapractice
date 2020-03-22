/**
Given a binary tree, return the sum of values of its deepest leaves.

  **/
public class DeepestLeavesSum {

	public static void main (String [] args)
	{
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n1.left = n2;
		n1.right = n3;
		
		n2.left = n4;
		n2.right = n5;
		
		n3.right = n6;
		
		n4.left = n7;
		
		n6.right = n8;
		
		DeepestLeavesSum sum = new DeepestLeavesSum();
		
		System.out.println(sum.deepestLeavesSum(n1));
	}
	
	
	int maxLevel= 0;
 	int maxLevelSum = 0;
 	
 	
 
	
	 public int deepestLeavesSum(TreeNode root) {
	        
		 	int currentLevel = 0;
		 	
		 	if(root == null)
		 		return 0;
		 	
		 	if(root.left == null && root.right == null)
		 		return root.val;
		 	
		 	
		 	 getDeepestLeavesSum(root, currentLevel);
		 
		 	 return maxLevelSum;
	    }
	 
	 void getDeepestLeavesSum(TreeNode root, int currentLevel)
	 {
		 
		 if(root.left == null && root.right == null)
		 {
			// We have reached the leaf node 
			
			if(currentLevel > maxLevel)
			{
				// New max level 
				
				maxLevel = currentLevel;
				maxLevelSum = root.val;
			}
			else if(currentLevel == maxLevel)
			{
				// Same level - so we can add 
				maxLevelSum += root.val;
			}
			// If this is less - then ignore 
			
		 }
		 
		 if(root.left != null)
		 {
			 getDeepestLeavesSum(root.left, currentLevel + 1);
		 }
		 
		 if(root.right != null)
		 {
			 getDeepestLeavesSum(root.right, currentLevel + 1);
		 }
		 
	 }
	
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	
}
