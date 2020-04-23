import java.util.ArrayList;
import java.util.List;
/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

Example 1:

Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

For a given n, a gray code sequence may not be uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence.

00 - 0
10 - 2
11 - 3
01 - 1
Example 2:

Input: 0
Output: [0]
Explanation: We define the gray code sequence to begin with 0.
             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
             Therefore, for n = 0 the gray code sequence is [0].
 * @author vpatil
 *
 */
public class GrayCode {
	
	public static void main(String [] args)
	{
		GrayCode gc = new GrayCode();
		
		List<Integer> results = gc.grayCode(3);
		
		for(int i: results)
			System.out.println(i);
	}

public List<Integer> grayCode(int n) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if(n == 0)
        {
            result.add(0);
            return result;
        }
        
        if(n == 1)
        {
            result.add(0);
            result.add(1);
            return result;
        }
        
       int numResults = new Double(Math.pow(2, n)).intValue();
        
        printResults(0, numResults-1, result, true);
        
        return result;
    }
    
    private void printResults(int startIndex, int endIndex, List<Integer> result , boolean isLeft )
    {
        
        if( ( endIndex - startIndex) == 1 )
        {
            if(isLeft)
            {
                result.add(startIndex);
                result.add(endIndex);
               // System.out.println(startIndex);
               // System.out.println(endIndex);
            }
            else
            {
                result.add(endIndex);
                result.add(startIndex);
              //  System.out.println(endIndex);
              //  System.out.println(startIndex);
            }
        }
        else
        {
            int mid = (startIndex + endIndex)/2;
            
            if(isLeft)
            {
                printResults(startIndex, mid, result, true);
                printResults(mid+1, endIndex, result, false);
            }
            else
            {
                printResults(mid+1, endIndex, result, true);
                printResults(startIndex, mid, result, false);
                
            }
            
            
        }
        
    }
    
    
    public List<Integer> grayCode2(int n) {
        List<Integer>res=new ArrayList<>();
        for(int i=0;i<Math.pow(2,n);i++){
            res.add(i^(i>>1));
        }
        return res;
    }
	
}
