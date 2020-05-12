/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 * @author vpatil
 *
 */
public class CheckStraightLine {
	
	public static void main(String [] args)
	{
		
		CheckStraightLine csl = new CheckStraightLine();
		int[][] coordinates = new int[][]{{1,1},{-3,1},{4,1}};
		
		System.out.println(csl.checkStraightLine(coordinates));
		
		
	}
	
public boolean checkStraightLine(int[][] coordinates) {
        
        if(coordinates == null || coordinates.length < 3)
            return true;
        
        
        float gradient = 0;
        
        boolean gradientset = false;
        
        boolean fixedX = false;
        boolean fixedY = false;
        
        for(int i = 0; i < coordinates.length -1; i++)
        {
            int x1 = coordinates[i][0];
            int y1 = coordinates[i][1];
            
            int x2 = coordinates[i+1][0];
            int y2 = coordinates[i+1][1];
            
            if(!gradientset)
            {
                if( (x2-x1) == 0)
                    fixedY = true;
                else if((y2-y1) == 0)
                    fixedX = true;
                else
                {
                    float xdiff = (x2-x1);
                    float ydiff = (y2-y1);
                    
                    gradient = ydiff/xdiff;
                }
                System.out.println("First time gradient "+gradient);
                gradientset = true;
            }
            else
            {
               if( (x2-x1) != 0  && fixedY)
                  return false;
               else if( (y2-y1) != 0 && fixedX)
                  return false;
             
              if(!fixedY && !fixedX)
              {
                  float xdiff = (x2-x1);
                  float ydiff = (y2-y1);
                  
                  System.out.println("Gradient "+gradient+" Xdiff "+xdiff+" Ydiff "+ydiff);
                
                if( (ydiff/xdiff) != gradient)
                    return false;
              }
             
            }
     
        }
        
        return true;
        
    }


public boolean checkStraightLine2(int[][] coordinates) {
   
     int x0 = coordinates[0][0], y0 = coordinates[0][1], x1 = coordinates[1][0], y1 = coordinates[1][1];
     int dx = x1 - x0, dy = y1 - y0;
     for (int[] co : coordinates) {
         int x = co[0], y = co[1];
         if (dx * (y - y1) != dy * (x - x1))
             return false;
     }
     return true;
 }
}
