/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
 * @author vpatil
 *
 */
public class PermutationInString {

	public static void main(String[] args) {
		PermutationInString pIns = new PermutationInString();
		String s1 = "ab";
		String s2 = "eidboaoo";
		
		System.out.println(pIns.checkInclusion(s1, s2));

	}

	public boolean checkInclusion(String s1, String s2) {
        
		if(s2 == null || s1 == null)
			return false;
		
		int s1Len = s1.length();
		int s2Len = s2.length();
		
		if(s1Len > s2Len)
			return false;
		
		
		int[] s1Array = new int[26];
		int[] s2Array = new int[26];
		
		for(int i=0;i < s1Len; i++)
		{
			s1Array[s1.charAt(i) - 'a']++;
			s2Array[s2.charAt(i) - 'a']++;
		}
		
		boolean found = true;
		
		for(int i= 0;i< 26; i++)
		{
			if(s1Array[i] != s2Array[i])
			{
				found = false;
				break;
			}
		}
		
		if(found) return true;
		
		for(int j = s1Len; j < s2Len; j++)
		{
			found = true;
			
			s2Array[s2.charAt(j-s1Len) - 'a'] --;
			s2Array[s2.charAt(j) - 'a'] ++;
			
			for(int i= 0;i< 26; i++)
			{
				if(s1Array[i] != s2Array[i])
				{
					found = false;
					break;
				}
			}
			
			if(found) return true;
		}
		
		return false;
    }
	
}
