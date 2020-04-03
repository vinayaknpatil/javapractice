/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 */

package gfg;


import java.util.Stack;
public class TemperatureCheck {

	public static void main(String [] args)
	{
		int [] input = new int[]{89,62,70,58,47,47,46,76,100,70};
		
		TemperatureCheck check = new TemperatureCheck();
		
		
		print(check.dailyTemperatures(input));
	}
	
	private static void print(int [] output)
	{
		for (int i: output)
		{
			System.out.print(i+",");
		}
		
		System.out.println("\n");
	}
	
public int[] dailyTemperatures(int[] T) {
        
        int[] results = new int [T.length];
        Stack<Integer> candidateIndexes = new Stack<Integer>();
        
        for(int i = T.length -1; i>=0 ; i--)
        {
            while( !candidateIndexes.isEmpty() && T[i] >= T[candidateIndexes.peek()])
            {
                candidateIndexes.pop();
            }
            if(candidateIndexes.isEmpty())
            {
                results[i] = 0;
            }
            else
            {
                results[i] = candidateIndexes.peek() -i;
            }
            
            candidateIndexes.push(i);
            
        }
        
        return results;
    }
}

