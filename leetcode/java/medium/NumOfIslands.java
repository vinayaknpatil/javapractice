/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by 
 * connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 * @author vpatil
 *
 */
public class NumOfIslands {
public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int islands = 0;
        
        for(int i=0; i< grid.length; i++)
        {
            for(int j=0; j < grid[i].length; j++)
            {
                if(grid[i][j] == '1') // Note the char 1 
                {
                    islands += checkNeighbours(grid, i, j);
                                     
                    //grid[i][j] = '0';
                }
                
            }
        }
        
        return islands;
    }
    
    public int checkNeighbours(char[][] grid, int i, int j)
    {
        if(i < 0 || i>= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') // Note the char 0
        {
            return 0;
        }
             
        grid[i][j] = '0'; // Note the char 0
        checkNeighbours(grid, i+1, j);
        checkNeighbours(grid, i-1, j);
        checkNeighbours(grid, i, j+1);
        checkNeighbours(grid, i, j-1);
        
        return 1;
    }
}
