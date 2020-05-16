/**
 * Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]
Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddElementsBTree {

public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        List<Integer> result = new ArrayList<Integer>();
        
         parseNode(root1, result);
         parseNode(root2, result);
        
        Collections.sort(result);
        
        return result;
        
    }
    
    void parseNode(TreeNode node, List<Integer> result)
    {
        if(node == null)
            return;
        
        // Because this is In order traversal, the lists will be in a sorted way 
        parseNode(node.left, result);
        result.add(node.val);
        parseNode(node.right, result);
    }
	
}
