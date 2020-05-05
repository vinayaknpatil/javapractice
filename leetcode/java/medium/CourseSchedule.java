import java.util.ArrayList;
import java.util.List;

/**
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5	
 * @author vpatil
 *
 *This uses DFS for graph
 */
public class CourseSchedule {
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses == 1)
			return true;
		
		Graph graph = new Graph(numCourses);
		
		for(int i=0; i < prerequisites.length ; i++)
		{
			int target = prerequisites[i][0];
            int dep = prerequisites[i][1];
            
            graph.addEdge(target, dep);
			
		}
		
		if(graph.isCyclic())
			return false;
		
		return true;
		
	}

	
	
}

class Graph
{
	int numVertices;
	
	List<List<Integer>> adj;
	
	public Graph(int numVertices)
	{
		this.numVertices = numVertices;
		
		adj = new ArrayList<>(numVertices);
		
		for(int i = 0; i < numVertices; i++)
			adj.add(new ArrayList<>());
	}
	
	void addEdge(int source, int dest)
	{
		adj.get(source).add(dest);
	}
	
	boolean isCyclic()
	{
		boolean[] rec = new boolean[numVertices];
		boolean[] visited = new boolean[numVertices];
		
		for(int i = 0; i< numVertices; i++)
			if(isCyclicUtil(i, visited, rec))
				return true;
		
		
		return false;
		
	}
	
	boolean isCyclicUtil(int i, boolean[] visited, boolean[] rec)
	{
		if(rec[i])
			return true;
		
		if(visited[i])
			return false;
		
		visited[i] = true;
		rec[i] = true;
		
		List<Integer> children = adj.get(i);
		
		for(int k: children)
			if(isCyclicUtil(k, visited, rec))
				return true;
		
		rec[i] = false;
		return false;
		
	}
	
}