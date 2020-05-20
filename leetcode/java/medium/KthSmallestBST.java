/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */


import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class KthSmallestBST {

public int kthSmallest(TreeNode root, int k) {
	Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	
	if(root == null)
		return -1;
	
	return getElement(root, maxHeap, k);
	
    }

private int getElement(TreeNode node, Queue<Integer> maxHeap, int k) {
	
	int val = -1;
	
	if(node.left != null)
		val = getElement(node.left, maxHeap, k);
	
	if(val > -1)
		return val;
	
	if(maxHeap.size() == k-1)
		return node.val;
	
	 maxHeap.add(node.val);
	
	 if(node.right != null)
	  val =  getElement(node.right, maxHeap, k);
		
	 if(val > -1)
	    return val;
	 
	 return -1;
	 
	 
}

public int kthSmallest2(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    while(root!=null||!stack.isEmpty()){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        TreeNode node = stack.pop();
        if(--k==0) return node.val;
        root = node.right;
    }
    return -1;
}


}
