/**
 * \Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 * @author vpatil
 *
 */
public class LongestPalindromeSubString {
	 public String longestPalindrome(String s) {
	        
	        if(s == null || s.length() < 1)
	            return "";
	        
	        int start = 0, end = 0;
	        
	        for(int i=0; i< s.length(); i++)
	        {
	            int len1 = expandFromMiddle(s, i, i);
	            int len2 = expandFromMiddle(s, i, i+1);
	            
	            int len = Math.max(len1,len2);
	            
	            if(len > (end-start))
	            {
	                start = i - ((len-1)/2);
	                end = i + (len/2);
	            }
	            
	        }
	        
	        return s.substring(start, end+1);
	        
	    }
	    
	    
	    int expandFromMiddle(String s, int start, int end)
	    {
	        if(s == null || start > end )
	            return 0;
	        
	        
	        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end))
	        {
	            start --;
	            end ++;
	        }
	        
	        return end - start -1;
	        
	    }
}
