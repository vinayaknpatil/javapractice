import java.util.HashMap;
import java.util.Map;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *  (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 * @author vpatil
 *
 */
public class ConvertString {

	public static void main(String [] args)
	{
		ConvertString cs = new ConvertString();
		
		System.out.println(cs.convert("PAYPALISHIRING", 4));
	}
	
	public String convert(String s, int numRows) {
	
		if(s == null || s.length() == 0)
            return s;
		
			if(numRows == 1)
				return s;
		
        StringBuffer[] split = new StringBuffer[numRows];
        
        for(int i=0; i< numRows; i++)
        	split[i] = new StringBuffer();
        
        boolean reverse = false;
        int index = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(! reverse)
            {
                split[index] = split[index].append(s.charAt(i));

                if(index == numRows -1)
                    reverse = true;
                
                else
                    index = index + 1;
            }
            else
            {
                split[index -1 ] = split[index -1].append(s.charAt(i));
                
                if(index == 1)
                {
                    reverse = false;
                    index = 1;
                }
                else
                {
                	index --;
                }
            }
                
        }
        
        StringBuffer result = new StringBuffer();
        for(int i=0;i<split.length;i++)
        {
        	System.out.println("String at "+i +" is "+split[i]);
        	result = result.append(split[i]);
        }
        
        
        return result.toString();
    }
	
	
	public String convert2(String s, int numRows) {
		Map<Integer, String> map = new HashMap<>();
		int col = 0, d = -1, idx = 0;
		while (idx < s.length()) {
			map.put(col, map.getOrDefault(col, "") + s.charAt(idx++));
			if (col == 0 || col == numRows - 1)
				d = -d;
			col += d;
		}
		String res = "";
		for (int i = 0; i < map.size(); i++) {
			res += map.getOrDefault(i, "");
		}
		return res;
	}
}
