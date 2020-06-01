import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 * @author vpatil
 *
 */
public class KPointCloseOrigin {

	public int[][] kClosest(int[][] points, int K) {
		
				
		if(K == points.length)
			return points;
		
		
		Queue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				
				Integer o1diff = o1.x* o1.x + o1.y * o1.y;
				Integer o2diff = o2.x* o2.x + o2.y * o2.y;
				
				return o2diff.compareTo(o1diff);
			}
		});
		
		
		for(int[] point: points)
		{
			Point p = new Point(point[0], point[1]);
			queue.add(p);
			
			if(queue.size() > K)
				queue.poll();
		}
		
		int[][] result = new int[K][2];
		
		for(int i=0; i< K; i++)
		{
			Point p = queue.poll();
			
			result[i][0] = p.x;
			result[i][1] = p.y;
		}
		
		return result;
  }
	
}

class Point
{
	int x;
	int y;
	
	Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	
	}
}