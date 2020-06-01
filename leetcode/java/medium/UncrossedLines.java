/**
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.

 

Example 1:


Input: A = [1,4,2], B = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
Example 2:

Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
Output: 3
Example 3:

Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
Output: 2
 

Note:

1 <= A.length <= 500
1 <= B.length <= 500
1 <= A[i], B[i] <= 2000
 * @author vpatil
 *
 */
public class UncrossedLines {

	public static void main(String [] args)
	{
		UncrossedLines ucl = new UncrossedLines();
		
		int [] A = new int []{2,5,1,2,5};
		int [] B = new int []{10,5,2,1,5,2};
		
		System.out.println(ucl.maxUncrossedLines(A, B));
	}
	
	public int maxUncrossedLines(int[] A, int[] B) {
	    
		int uncrossedLines = 0;
		
		
		if(A == null || A.length == 0 || B == null || B.length == 0)
			return uncrossedLines;
		
		
		int aLength = A.length;
		int bLength = B.length;
		
		int[][]lookup = new int[aLength+1][bLength+1];
		
		
		for(int i=0; i< aLength; i++)
		{
			for(int j =0;j<bLength;j++)
			{
				if(A[i] == B[j])
				{
					lookup[i+1][j+1] = lookup[i][j] +1; 
				}
				else
				{
					lookup[i+1][j+1] = Math.max(lookup[i][j+1], lookup[i+1][j]);
				}
				
			}
		}
		
		return lookup[aLength][bLength];
		
		
    }
	
}
