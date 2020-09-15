import java.util.ArrayList;
import java.util.List;

/**
 * (This problem is an interactive problem.)

A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, 
return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent 
the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the 
binary matrix directly.

 

Example 1:



Input: mat = [[0,0],[1,1]]
Output: 0
Example 2:



Input: mat = [[0,0],[0,1]]
Output: 1
Example 3:



Input: mat = [[0,0],[0,0]]
Output: -1
Example 4:



Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
Output: 1
 

Constraints:

1 <= mat.length, mat[i].length <= 100
mat[i][j] is either 0 or 1.
mat[i] is sorted in a non-decreasing way.
 * @author vpatil
 *
 */
public class LeftMostColumnOne {

	 public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
	        
	        int globalMin = -1;
	        
	        if(binaryMatrix == null)
	            return globalMin;
	        
	        List<Integer> dim = binaryMatrix.dimensions();
	        
	        int rows = dim.get(0);
	        int columns = dim.get(1);
	        
	        if(rows == 0 && columns == 0)
	            return globalMin;
	        
	        int colSize = columns -1;
	        
	      //  System.out.println("Rows "+rows+" Columnns "+columns);
	        
	        for(int i = 0 ; i < rows; i++)
	        {
	        	if(globalMin > -1)
	        	{
	        		colSize = globalMin -1;
	        	}
	        	
	            int rowMin = getRowMin(i, 0, colSize, binaryMatrix);
	            
	           // System.out.println("Min for row "+i + " is "+rowMin);
	            
	            if(rowMin == 0)
	                return 0;
	            
	            if(globalMin == -1 || ( rowMin > 0 && rowMin < globalMin) )
	            {
	                globalMin = rowMin;
	            }
	            
	           // System.out.println("Global min "+globalMin);
	        }
	        
	        return globalMin;
	               
	    }
	    
	    int getRowMin(int rowNum, int startIndex, int endIndex,BinaryMatrix binaryMatrix )
	    {
	    	 
	        if(startIndex > endIndex)
	            return -1;
	        
	        if(binaryMatrix.get(rowNum, endIndex) == 0)
                return -1;
	        
	        int mid = (startIndex + endIndex)/2;
	        
	        if(binaryMatrix.get(rowNum, mid) == 1) // Keep checking on the left side 
	        {
	            int leftMin = getRowMin(rowNum, startIndex, endIndex -1,binaryMatrix );
	            
	            if(leftMin == -1)
	                return mid;
	            else
	                return leftMin;
	            
	        }
	        else // Since we are going to the right side and the mid is greater or equals the global Min 
	        	// we wont find a smaller number so return -1;
	        {
	        	return getRowMin(rowNum, startIndex + 1, endIndex, binaryMatrix);
	        }
	        
	    }
}

class BinaryMatrix
{
	public int get(int x, int y)
	{
		return 0;
	}
	
	public List<Integer> dimensions()
	{
		return new ArrayList<>();
	}
}
