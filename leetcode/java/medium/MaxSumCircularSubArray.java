/**
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)

 

Example 1:

Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3
Example 2:

Input: [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
Example 3:

Input: [3,-1,2,-1]
Output: 4
Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
Example 4:

Input: [3,-2,2,-3]
Output: 3
Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
Example 5:

Input: [-2,-3,-1]
Output: -1
Explanation: Subarray [-1] has maximum sum -1
 

Note:

-30000 <= A[i] <= 30000
1 <= A.length <= 30000
 * @author vpatil
 *
 */
public class MaxSumCircularSubArray {
	
	public static void main(String [] args)
	{
		MaxSumCircularSubArray msa = new MaxSumCircularSubArray();
		
		int[] A = new int[]{1,-2,3,-2};
		
		System.out.println(msa.maxSubarraySumCircular(A));
		
	}
	
	  public int maxSubarraySumCircular(int[] A) {
	  
		  // Create a new array with size 2N - 1
		  
		  if(A == null || A.length == 0)
			  return 0;
		  
		  int maxValue = A[0];
		  
		  int arrayLen = A.length;
		  
		  int [] N = new int [ (2*arrayLen) -1];
		  
		  for(int i = 0 ; i < N.length; i++)
		  {
			  N[i] = A[i%arrayLen];
		  }
		  
		  for(int i = 0; i< arrayLen; i++)
		  {
			  maxValue = Math.max(maxValue, getMaxInSubArray(N, i, arrayLen));
		  }
		  
		  // For each element till N -1, get the max using Kadane's algo.. take the max 
		  
		  return maxValue;
		  
	  }
	  
	  
	  public int getMaxInSubArray(int [] N, int startIndex, int arrayLen)
	  {
		  
		 int [] lookup = new int[arrayLen]; 
		  
		 lookup[0] = N[startIndex];
		 
		 int globalMax = lookup[0];
		 
		 for(int i = 1; i< arrayLen; i++)
		 {
			 
			 int nIndex = startIndex+i;
			 
			 lookup[i] = Math.max(N[nIndex], lookup[i-1]+N[nIndex]);
			 
			 globalMax = Math.max(lookup[i], globalMax);
			 
		 }
		  
		//  System.out.println("Max value for index "+startIndex +" is "+globalMax);
		  return globalMax;
		  
	  }
	
}
