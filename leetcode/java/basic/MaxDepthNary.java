/**
 * Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, 
each group of children is separated by the null value (See examples).
 */


import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxDepthNary {
	
	public static void main(String [] args)
	{
		
		Node n2 = new Node(2);
		
		Node n6 = new Node(6);
		
		Node n10 = new Node(10);
		
		Node n12 = new Node(12);
		Node n13 = new Node(13);
		Node n14 = new Node(14);
		
		List<Node> l1 = new ArrayList<>();
		l1.add(n14);
		Node n11= new Node(11, l1);
		
		List<Node> l2 = new ArrayList<>();
		l2.add(n12);
		Node n8 = new Node(8, l2);
		
		List<Node> l3 = new ArrayList<>();
		l3.add(n13);
		Node n9 = new Node(9, l3);
		
		List<Node> l4 = new ArrayList<>();
		l4.add(n11);
		Node n7 = new Node(7, l4);
		
		List<Node> l5 = new ArrayList<>();
		l5.add(n6);
		l5.add(n7);
		Node n3 = new Node(3, l5);
		
		
		List<Node> l6 = new ArrayList<>();
		l6.add(n8);
		Node n4 = new Node(4, l6);
		
		List<Node> l7 = new ArrayList<>();
		l7.add(n9);
		l7.add(n10);
		Node n5 = new Node(5,l7);
		
		
		List<Node> l8 = new ArrayList<>();
		l8.add(n2);
		l8.add(n3);
		l8.add(n4);
		l8.add(n5);
		
		Node n1 = new Node(1,l8);
		
		System.out.println(new MaxDepthNary().maxDepth(n1));
		
	}

public int maxDepth(Node root) {
        
        // Put the nodes in queues;
	
	if(root == null)
		return 0;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        // add root in queue 
        
        int maxLevel = 0;
        while( !queue.isEmpty())
        {
        	maxLevel ++;
            
            Queue<Node> tempQueue = new LinkedList<Node>();
                
            while(!queue.isEmpty())
            {
                Node top = queue.remove();
                
                if(top.children != null)
                {
	                for(Node n: top.children)
	                {
	                    tempQueue.add(n);
	                }
                }
            }
            
            queue = tempQueue;
        }
        
        return maxLevel;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
