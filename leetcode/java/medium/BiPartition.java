import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Possible Bipartition
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Note:

1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].
 * @author vpatil
 *
 */
public class BiPartition {
	
	 public static void main(String [] args)
	 {
		 BiPartition bip = new BiPartition();
		 
		 int N = 10;
		 int [][] dislikes = new int[][]
				 {{5,9},{5,10},{5,6},{5,7},{1,5},{4,5},{2,5},{5,8},{3,5}};
		 
		 System.out.println(bip.possibleBipartition(N, dislikes));
		 
	 }
	
	 ArrayList<Integer>[] graph;
		Map<Integer, Integer> colorMap;
		 
		 
		 public boolean possibleBipartition(int N, int[][] dislikes) {
		        if(dislikes == null || dislikes.length == 0)
		        	return true;
		        
		        
		        graph = new ArrayList[N+1];
		        
		        for(int i=1; i<= N;i++ )
		        	graph[i] = new ArrayList<>();
		        
		        for(int[] dlike: dislikes)
		        {
		        	graph[dlike[0]].add(dlike[1]);
		        	graph[dlike[1]].add(dlike[0]);
		        }
		        
		        colorMap = new HashMap<Integer, Integer>();
		       
		        for(int i = 1; i<= N; i++)
		        {
		        	if(!colorMap.containsKey(i) && !isBipartite(i, 1))
		        		return false;
		        }
		       return true;
		 }
		 
		 boolean isBipartite(int node, int colour)
		 {
			 
			 if(colorMap.containsKey(node))
				 return colorMap.get(node) == colour;
			 
			 
			 colorMap.put(node, colour);
			 
			 for(int next: graph[node])
			 {
				 if(!isBipartite(next, -colour))
					 return false;
			 }
			 return true;
			 
		 }
}

