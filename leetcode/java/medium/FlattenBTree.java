/**
 * Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 * @author vpatil
 *
 */
public class FlattenBTree {
	public static void main(String[] args)
	{
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		n1.left = n2;
		n1.right= n5;
		
		n2.left = n3;
		n2.right = n4;
		
		n5.right = n6;
		
		
		new FlattenBTree().flatten(n1);
		
		while(true)
		{
			System.out.println(n1.val);
			
			if(n1.left == null && n1.right == null)
				break;
			
			if(n1.left != null)
				n1 = n1.left;
			
			
			if(n1.right != null)
				n1 = n1.right;
			
		}
		
	}
	
	
public void flatten(TreeNode root) {
        
		if(root == null)
			return;
		
		// Move left nodes to right 
		
		TreeNode temp = root.right;
		
		root.right = root.left;
		root.left = null;
		
		// Now move the existing right to the end of the new right 
		if(temp != null)
			moveRightNodeAtEnd(root, temp);
		
		// Call flatten recursively on right side 
		flatten(root.right);
		
		
    }

	private void moveRightNodeAtEnd(TreeNode root, TreeNode temp)
	{
		
		while(root.right != null)
		{
			System.out.println("Navigating thru right");
			root = root.right;
		}
		
		root.right = temp;
	}

}

