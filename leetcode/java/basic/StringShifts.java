/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

direction can be 0 (for left shift) or 1 (for right shift). 
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.
 * @author vpatil
 *
 */
public class StringShifts {
	
	public static void main(String [] args)
	{
		StringShifts ss = new StringShifts();
		
		String s = "abcdefg";
		
		int [] [] shift = new int [][] { {0,1},{0,1},{1,2},{0,3}};
		
		System.out.println(ss.stringShift(s, shift));
	}
	

	public String stringShift(String s, int[][] shift) {
	    
		if(s == null || s.length() == 0)
			return s;
		
		if(shift == null || shift.length == 0)
			return s;
		
		int totalShift = 0;
		
		for(int i = 0; i < shift.length; i++)
		{
					
			if(shift[i][0] == 0)
				totalShift -=shift[i][1];
			else
				totalShift += shift[i][1];
			
		}
		
		boolean isLeft = false;
		
		//System.out.println("Total Shift "+totalShift );
		
		if(totalShift < 0)
		{
			isLeft = true;
			
			totalShift = Math.abs(totalShift);
		}
		
		totalShift = totalShift % s.length();
		
		if(totalShift == 0)
			return s;
		
		//System.out.println("Total Shift "+totalShift );
		
		
		StringBuffer result = new StringBuffer();
		
		if(!isLeft)
		{
			for(int i = s.length() - totalShift; i < s.length(); i++)
				result.append(s.charAt(i));
			
			for(int i = 0; i < s.length() - totalShift ; i++)
				result.append(s.charAt(i));
		}
		else
		{
			for (int i = totalShift; i < s.length(); i++)
				result.append(s.charAt(i));
			
			for(int i = 0 ; i < totalShift; i++)
				result.append(s.charAt(i));
		}
        // First figure out whats the total shift needed 
        
    
		// For right - keep adding , for left subtract 
        
		return result.toString();
		
    }
	
}
