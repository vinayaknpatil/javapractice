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
	
	 
}
