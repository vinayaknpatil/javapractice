/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 * @author vpatil
 *
 */
public class MaximalSquare {

	 public int maximalSquare(char[][] matrix) {
	     
			if(matrix == null || matrix.length == 0)
				return 0;
			
			int [][] ms = new int[matrix.length][matrix[0].length];
			
			int globalMax = 0;
			
			for(int i = 0; i < matrix.length ;i++)
			{
				
				for(int j=0; j< matrix[0].length; j++)
				{
					if(i==0 || j==0)
					{
						if(matrix[i][j] == '1')
						{
							ms[i][j] = 1;
							globalMax = Math.max(globalMax, ms[i][j]);
						}
					}
					else
					{
						if(matrix[i][j] == '1')
						{
							ms[i][j] = Math.min(ms[i][j-1], Math.min(ms[i-1][j], ms[i-1][j-1]))+1;
							
							globalMax = Math.max(globalMax, ms[i][j]);
						}
					}
				}
				
			}
			
			return globalMax * globalMax;
			
		
	    }
	
}
