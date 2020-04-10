/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
 * @author vpatil
 *
 */
public class BackSpaceCompare {

	
	public static void main(String [] args)
	{
		BackSpaceCompare comp = new BackSpaceCompare();
		
		System.out.println(comp.backspaceCompare("a#c", "b"));
	}
	
public boolean backspaceCompare(String S, String T) {
        
        if(S == null && T == null)
            return true;
        
        if(S == null || T == null)
            return false;
        
        // Start with the end element 
        
        StringBuffer sBuf = new StringBuffer();
        
        int count = 0;
        
        for(int i = S.length() -1 ; i >= 0 ; i--)
        {
            if(S.charAt(i) == '#')
                count++;
            else if (count > 0)
            			count--;
            else
                sBuf.append(S.charAt(i));
                    
        }
        
        StringBuffer tBuf = new StringBuffer();
        count = 0;
        
        for(int i = T.length() -1 ; i >= 0 ; i--)
        {
            if(T.charAt(i) == '#')
                count++;
            else if (count > 0 )
            	count--;
            else
                tBuf.append(T.charAt(i));
                    
        }
           
        // Now compare both 
        
        return sBuf.toString().equals(tBuf.toString());
        
    }
}
