/*
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are
 *  drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, 
 *  such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */

public class WaterContainerArea {

	public static void main (String []args)
	{
		WaterContainerArea area = new WaterContainerArea();
		
		int [] height = {1,8,6,2,5,4,8,3,7};
		
		System.out.println(area.maxArea(height));
	}
	
	
public int maxAreaBruteForce(int[] height) {
        
		if(height == null || height.length < 2)
			return 0;
	
		
		int maxPossibleArea = 0;
		
		int size = height.length;
		
		for(int i = 0; i < size - 1; i++ )
		{
			for(int j = i+1; j < size ; j++)
			{
				int area = min(height[i], height[j]) * (j-i);
				
				if(area > maxPossibleArea)
				{
					maxPossibleArea = area;
				}
			}
		}
		
		return maxPossibleArea;
    }

public int maxArea(int[] height) {
	
	if(height == null || height.length < 2)
		return 0;

	
	int maxPossibleArea = 0;
	
	int size = height.length;
	
	int i = 0, j = size -1;
	
	while(i < j)
	{
		if(height[i] > height[j])
		{
			int tempArea =  height[j] * (j-i);
			
			maxPossibleArea = Math.max(maxPossibleArea, tempArea);
			
			/*if(tempArea > maxPossibleArea)
			{
				maxPossibleArea = tempArea;
				
				
			}
			*/
			j--;
		}
		else
		{
			int tempArea = height[i] * (j-i);
			
			maxPossibleArea = Math.max(maxPossibleArea, tempArea);
			
			/*if(tempArea > maxPossibleArea)
			{
				maxPossibleArea = tempArea;
				
				
			}*/
			
			i++;
		}
	}
	
	return maxPossibleArea;
	
}

int min (int a, int b)
{
	if (a < b )
		return a;
	
	return b;
}
	
	
}
