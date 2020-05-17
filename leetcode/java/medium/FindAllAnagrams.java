import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".

 * @author vpatil
 *
 */
public class FindAllAnagrams {
	
	public static void main(String [] args)
	{
		FindAllAnagrams findAllAn = new FindAllAnagrams();
		
		String s = "abcded";
		String p = "ded";
		
		for(int i: findAllAn.findAnagrams(s, p))
			System.out.println(i);
		
	}
	
	
	public List<Integer> findAnagrams(String s, String p) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		if(s == null || p == null)
			return result;
		
		
		if(p.length() > s.length()) // Since p is longer than s , cant be an anagram 
			return result;
		
		int[] difference = getInitialDiff(s, p);
		       
        int nonZeroCount = 0;
        
        for(int diff: difference)
        {
        	if(diff != 0)
        		nonZeroCount++;
        }
        
        if(nonZeroCount == 0)
        	result.add(0);
		
        for(int i = 1; i <= s.length() - p.length(); i++)
        {
        	int reduceIndex = s.charAt(i-1) -'a';
        	
        	if(difference[reduceIndex] == 1)
        	{
        		nonZeroCount --;
        	}
        	else if(difference[reduceIndex] == 0)
        	{
        		nonZeroCount ++;
        	}
      
        	
        	difference[reduceIndex] --;
        	
        	int addIndex = s.charAt(i -1 + p.length()) - 'a';
        	
        	if(difference[addIndex] == -1)
        	{
        		nonZeroCount --;
        	}
        	else if(difference[addIndex] == 0)
        	{
        		nonZeroCount ++;
        	}
        	
        	difference[addIndex] ++;
        	        	
        	if(nonZeroCount == 0)
        		result.add(i);
        }
        
		return result;
    }
	
	int[] getInitialDiff(String s, String p)
	{
		
        int[] difference = new int[26];
        
        for(int i= 0; i< p.length(); i++)
        {
        	difference[s.charAt(i) - 'a']++;
        	difference[p.charAt(i) - 'a']--;
        }
        
        return difference;
	}

}
