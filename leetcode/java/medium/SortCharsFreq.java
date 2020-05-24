/**
 * Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 * @author vpatil
 *
 */
public class SortCharsFreq {
	
	public static void main(String [] args)
	{
		SortCharsFreq scf = new SortCharsFreq();
		String input = "Aabb";
		
		System.out.println(scf.frequencySort(input));
		
	}
	
	
	public String frequencySort(String s) 
	{
	  
		if(s == null || s.length() == 0)
			return s;
		
		// Have 2 arrays , one to maintain the char frequencies  other one to maintain freq of freq 
		
		int[] frequency = new int[255];
		
		int[] occurFreq = new int[s.length()+1];
		
		for(int i = 0; i < s.length(); i++)
		{
			frequency[s.charAt(i)]++;
			
			// If a character count is now 3, then decrease the count at old freq index at 2 and increase for 3
			occurFreq[frequency[s.charAt(i)]]++;
			
			int oldFreqIndex = frequency[s.charAt(i)]-1;
			occurFreq[oldFreqIndex]--; 
			
		}
		
		// Now loop thru occurFreq in reverse 
		
		StringBuffer result = new StringBuffer();
		
		for(int j = occurFreq.length -1 ; j >= 0; j--)
		{
			if(occurFreq[j] > 0)
			{
				result.append(getRepeatedData(frequency, j) );
			}
		}
		
		
			return result.toString();
	}
		
	String getRepeatedData(int[] frequency, int numOccurence)
	{
		StringBuffer data = new StringBuffer();
			
		for(int i = 0; i< frequency.length; i++)
		{
			if(frequency[i] == numOccurence)
			{
				for(int j = 0 ; j< numOccurence; j++)
					data.append( (char) i);
			}
		}
			
		return data.toString();
			
	}

	// 2ms
	public String frequencySort2(String s) {
		if(s.isEmpty() || s.length()==0)
            return s;
        int[] map = new int[128];
        char[] cA = s.toCharArray();
        
        for(char c:cA)
            map[c]++;
        
        char[] result = new char[s.length()];
        for(int i=0;i<s.length();){
            int max = 0;
            int index = 0;
            for(int j = 0;j<128;j++){
                if(map[j]>max){
                    max = map[j];
                    index = j;
                }
            }
            while(map[index]>0){
                result[i++] = (char)index;
                map[index]--;
            }
        }
        return new String(result);
    }
	
}


