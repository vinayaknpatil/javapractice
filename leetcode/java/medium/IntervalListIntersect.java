import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  
The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval. 
 For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 * @author vpatil
 *
 */

/**
 * Solution - Sliding window compare .. start with comparing first elements of both rows.. 
 * Then move the index of the one which has the smaller second element. Keep doing this till we reach 
 * end of any of the arrays.
 * 
 * Intersection - Get the max of the first digits and the min of the second digits. 
 * If the first is smaller than or equal to the second one - then we have a result 
 * Else not . 
 * @author vpatil
 *
 */
public class IntervalListIntersect {

	public static void main(String[] args) {
		int [][] A = new int[][]{{0,2},{5,10},{13,23},{24,25}};
		int [][] B = new int[][]{{1,5},{8,12},{15,24},{25,26}};
		
		IntervalListIntersect ili = new IntervalListIntersect();
		
		int [][] res = ili.intervalIntersection(A, B);
		
		for(int[] entry: res)
		{
			System.out.print(entry[0]+"---"+entry[1]);
			System.out.println("");
		}

	}
	
	 public int[][] intervalIntersection(int[][] A, int[][] B) {
	 
		 if(A == null || A.length == 0 || B == null || B.length == 0)
			 return new int[0][0];
		 
		 
		 List<int[]> result = new ArrayList<int[]>();
		 
		 int aLen = A.length;
		 int bLen = B.length;
		 
		 int i = 0,j = 0;
		 
		 while(i < aLen && j < bLen)
		 {
			 int[] t = null;
			 if ( ( t = getIntersection(A[i], B[j]) ) != null)
			 {
				 result.add(t);
			 }
			 
			 /*if(t != null)
			 {
				 result.add(t);
			 }
			 */
			 
			 if(A[i][1] <= B[j][1])
				 i++;
			 else
				 j++;
			 
		 }
		 
		 int[][] response = new int[result.size()][2];
		 
		 for(int k= 0; k < result.size(); k++)
		 {
			 response[k] = result.get(k);
		 }
		 
		 return response;
		 
	 }

	private int[] getIntersection(int[] a, int[] b) {
		
		int first = Math.max(a[0], b[0]);
		int second = Math.min(a[1], b[1]);
		
		if(first <= second)
		{
			int[] resp = new int[2];
			 resp[0] = first;
			 resp[1] = second;
			 
			 return resp;
		}
		
		return null;
	}

}

/*class Tuple
{
	int a;
	int b;
	
	Tuple(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	
}*/