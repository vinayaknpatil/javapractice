/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. 
(eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
 * @author vpatil
 *
 */
public class LongestCommonSubsequence {

	public static void main(String [] args)
	{
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String text1 = "abc";
		String text2 = "d";
		
		
		System.out.println(lcs.longestCommonSubsequence(text1, text2));
	}
	
	public int longestCommonSubsequence(String text1, String text2) {
     
		if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
			return 0;
		
		int len1 = 0;
		int len2 = 0;
		
		if(text1 != null)
			len1 = text1.length();
		
		if(text2 != null)
			len2 = text2.length();
		
		
		int[][]lookup = new int[len1+1][len2+1]; // Look up table of m+1, n+1 size
		
		for(int i = 0; i <= len1; i++)
		{
			for(int j = 0; j <= len2; j++)
			{
				if(i==0 || j==0)
				{
					lookup[i][j] = 0;  // Initializing first to 0 for both strings
				}
				else if(text1.charAt(i-1) == text2.charAt(j-1)) // If match, then check previous character entry and add 1 
				{
					lookup[i][j] = lookup[i-1][j-1]+1;
				}
				else
				{
					lookup[i][j] = Math.max(lookup[i-1][j], lookup[i][j-1]); // Else its max of the one char less each side compared to the current size.
				}
			
			}
		}
		
		
		return lookup[len1][len2]; // Last entry will have the max value
		
    }
	
}

