/**
  Given a string, find the length of the longest substring without repeating characters.
  **/

public class LongestSubString {
	
	public static void main(String [] args)
	{
		LongestSubString ls = new LongestSubString();
		String input = "";
		
		input = "abcabcbb";
		System.out.println(ls.lengthOfLongestSubstring(input));
		input = "bbbbb";
		System.out.println(ls.lengthOfLongestSubstring(input));
		input = " ";
		System.out.println(ls.lengthOfLongestSubstring(input));
		input = null;
		System.out.println(ls.lengthOfLongestSubstring(input));
		input = "";
		System.out.println(ls.lengthOfLongestSubstring(input));
		input = "pwwkew";
		System.out.println(ls.lengthOfLongestSubstring(input));
		
		input = "tmmtzuxt";
		System.out.println(ls.lengthOfLongestSubstring(input));
		
		input = "btablud";
		System.out.println(ls.lengthOfLongestSubstring(input));
		
		
		input = "hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		System.out.println(ls.lengthOfLongestSubstring(input));
	}
	
	
	public int lengthOfLongestSubstring(String s) {
	   
		 // first do a lower case 
		 
		 if(s == null || s.equals(""))
			 return 0;
		 
		s = s.trim();
		 
		 if(s.length() == 0)
			 return 1;
		 
				 
		 // Create an array of 26 
		 
		 int [] indexArray = new int [255];
		 
		 int maxCount = 0;
		
		 int newStart = 0;
		 int runningCount = 0;		 
		 int matchIndex = 0;
		 
		 for(int i=0; i< s.length(); i++)
		 {
			 char c = s.charAt(i);
			 
			// System.out.println(c);
			 
			 
			 
			 if( ( indexArray[ c]) == 0)
			 {
				 indexArray[c] = i+1;
			 }
			 else
			 {
				 runningCount = i - newStart;
				 
					// System.out.println("Running count "+runningCount);
					 
			     if(runningCount > maxCount)
				{
			    	 maxCount = runningCount;
						
				}
				 
				 matchIndex = indexArray[c];
				// System.out.println("Match Index "+matchIndex);	
				 
				 if(matchIndex > newStart)
				 {	 
					  
					 newStart = matchIndex;
				 } 	 
					 //System.out.println("New start "+newStart);
					 
					 indexArray[c] = i+1;
				 }
			 }
		 
	 
		 runningCount = s.length() - newStart;
		 
	//	 System.out.println("Last running count "+runningCount);
		 
		 if(runningCount > maxCount)
		 {
			 maxCount = runningCount;
		 }
	 
		 return maxCount;
		 
	   }
	
	 
	
	/*static int longestUniqueSubsttr(String str) 
    { 
		static final int NO_OF_CHARS = 256; 
        int n = str.length(); 
  
        int res = 0; // result 
  
        // last index of all characters is initialized 
        // as -1 
        int [] lastIndex = new int[NO_OF_CHARS]; 
        Arrays.fill(lastIndex, -1); 
  
        // Initialize start of current window 
        int i = 0; 
  
        // Move end of current window 
        for (int j = 0; j < n; j++) { 
  
            // Find the last index of str[j] 
            // Update i (starting index of current window) 
            // as maximum of current value of i and last 
            // index plus 1 
            i = Math.max(i, lastIndex[str.charAt(j)] + 1); 
  
            // Update result if we get a larger window 
            res = Math.max(res, j - i + 1); 
  
            // Update last index of j. 
            lastIndex[str.charAt(j)] = j; 
        } 
        return res; 
    }
	*/
}
