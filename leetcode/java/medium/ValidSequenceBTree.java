/**
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree. 

We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.

 

Example 1:



Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
Output: true
Explanation: 
The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
Other valid sequences are: 
0 -> 1 -> 1 -> 0 
0 -> 0 -> 0
Example 2:



Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
Output: false 
Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
Example 3:



Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
Output: false
Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 

Constraints:

1 <= arr.length <= 5000
0 <= arr[i] <= 9
Each node's value is between [0 - 9].
 * @author vpatil
 *
 */
public class ValidSequenceBTree {
	
	public static void main(String [] args)
	{
		ValidSequenceBTree bt = new ValidSequenceBTree();
		
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(2);
		
		n1.left = n2;
				 
		TreeNode n4 = new TreeNode(1);
		n2.left = n3;
		n2.right = n4;
		
		TreeNode n5 = new TreeNode(5);
		n3.left = n5;
		
		TreeNode n6 = new TreeNode(4);
		n3.right = n6;
		
		
		int arr [] = {8};
		
		System.out.println(bt.isValidSequence(n1, arr));
		
	}
	
public boolean isValidSequence(TreeNode root, int[] arr) {
        
        // Basic checks 
        
        if(root == null || arr == null || arr.length == 0)
            return false;
        
        return checkValidSeq(root, arr, 0);
        
    }
    
    boolean checkValidSeq(TreeNode node,int[] arr, int index )
    {
        int arrLen = arr.length;
        
        boolean isLeaf = isLeafNode(node);
        
        if(index == arrLen -1 && !isLeaf) // last index but not leaf 
           return false;

        
        if(isLeaf && index < arrLen -1) // Leaf but not last index
            return false;
         
        if(node.val != arr[index]) // Values do not match 
            return false;
        
        if(isLeaf && index == arrLen -1 && node.val == arr[index])
           return true;
        
        boolean validLeft = false;
        boolean validRight = false;
        
        if(node.left != null)
            validLeft = checkValidSeq(node.left, arr, index+1);
        
        if(node.right != null)
            validRight = checkValidSeq(node.right, arr, index+1);
        
        
        return validLeft || validRight;
        
    }
    
    boolean isLeafNode(TreeNode node)
    {
        if(node.left == null && node.right == null)
            return true;
        
        return false;
    }
}
