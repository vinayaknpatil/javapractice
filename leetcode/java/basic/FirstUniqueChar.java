/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 * @author vpatil
 *
 */
public class FirstUniqueChar {
	
	public static void main(String [] args)
	{
		FirstUniqueChar unCh = new FirstUniqueChar();
		
		String s = "lovteldeetcodevc";
		
		System.out.println(unCh.firstUniqChar(s));
	}

	 public int firstUniqChar(String s) {
	        
	        if(s == null || s.length() == 0 )
	            return -1;
	        
	        int [] array = new int[26];
	        
	        for(int i=0; i< s.length() ; i++)
	        {
	            array[s.charAt(i) - 'a'] ++;
	        }
	        
	        for(int i=0; i< s.length() ; i++)
	        {
	            if(array[s.charAt(i) - 'a'] == 1)
	                return i;
	        }
	        
	        return -1;
	        
	    }
}
