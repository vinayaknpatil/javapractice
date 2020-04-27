/**
 * Given an input string, reverse the string word by word.

 

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
 * @author vpatil
 *
 */

public class ReverseWordsString {
	
	public static void main(String [] args)
	{
		ReverseWordsString rws = new ReverseWordsString();
		String s  = "a good   example";
		System.out.println(rws.reverseWords(s));
	}
	

public String reverseWords(String s) {
     
		if(s == null)
			return s;
		
		String input = s.trim();
		
		if(input.length() == 0)
			return input;
		
		
		StringBuffer result = new StringBuffer();
		StringBuffer temp = new StringBuffer();
		
		for(int i = input.length() - 1; i>=0; i--)
		{
			if(input.charAt(i) == ' ' && temp.length() == 0)
				continue;
			
			if(input.charAt(i) == ' ') // We got a space after a word
			{
				if(result.length() == 0)
				{
					//System.out.println("First word "+temp.toString());
					result.append(temp);
					temp = new StringBuffer();
				}
				else
				{
					result.append(' ');
					result.append(temp);
					
				//	System.out.println("Next word "+temp.toString());
					temp = new StringBuffer();
				}
				
			}
			else
			{
				temp.insert(0, input.charAt(i));
			}
			
		}
		
		if(temp.length() > 0)
		{
			result.append(' ');
			result.append(temp);
		}
			
	
		return result.toString().trim();
    }
	

public String reverseWords2(String s) {
    String[] words = s.split(" ");
    StringBuilder stringBuilder = new StringBuilder();
    int wordsLength = words.length;
    for (int i = wordsLength - 1; i >= 0; i--) {
        String nextWord = words[i];
        if (nextWord.length() > 0) {
            if (i < wordsLength - 1) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(nextWord);

        }
    }
    return stringBuilder.toString();
}
}

