/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.
 * @author vpatil
 *
 */
public class ReverseString {
	
	public void reverseString(char[] s) {
        if(s == null || s.length == 0)
            return;
        
        int i = 0;
        int j = s.length -1;
        
        while(i < j)
        {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            
            i++;
            j--;
        }
    }
}

