public class Find2DMatrix {

	public static void main(String [] args)
	{
		Find2DMatrix mat = new Find2DMatrix();
		/*int [][] input = new int[][] {
			{1,   3,  5,  7},
			{10, 11, 16, 20},
			{23, 30, 34, 50}
		};
		*/
		
		int [][] input = new int[][] {
			
			{1,   3,  5,  7},
		
		};
		
		System.out.println(mat.searchMatrix(input, 9));
	}
	
	 public boolean searchMatrix(int[][] matrix, int target) {
		 
		 if(matrix == null)
		 {
			 return false;
		 }
		 
		 // Find the total number of elements in the array 
		 
		 int numRows = matrix.length;
		 
         if(numRows == 0)
			 return false;
        
		 int numCols = matrix[0].length;
		 
		 int totalValues = numRows * numCols;
		 
		 // Now do a binary search 
		 
		 int start = 0;
		 
		 int end = totalValues - 1;
		 
		 
		 while(start <= end)
		 {
			 int mid = (start+end) /2;
			 
			 int data = matrix[mid/numCols][mid % numCols];
			 
			 if(data == target)
			 {
				 return true;
			 }
			 else if(data > target)
			 {
				 end = mid - 1;
			 }
			 else
			 {
				 start = mid + 1;
			 }
		 }
		 
		 return false;
		 
	 }
	
}
