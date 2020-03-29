public class LongestCommonPrefix {

	public static void main(String [] args)
	{
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		
		String [] strs = new String []{"flower","flow","flowfg","floging"};
		
		System.out.println(lcp.longestCommonPrefix(strs));
	}
	
public String longestCommonPrefix(String[] strs) {
        
		if(strs == null || strs.length == 0)
			return "";
		
		int commonIndex = -1;
		
		// Find the minimum length 
		
		int minLen = Integer.MAX_VALUE;
		
		for(int i = 0; i < strs.length; i++)
		{
			if(strs[i] == null || strs[i].length() == 0)
				return "";
			
			
			if(strs[i].length() < minLen)
				minLen = strs[i].length();
			
		}
		
		
		for(int i = 0 ; i< minLen ; i++)
		{
			if( !getSameChar(strs, i))
			{
				break;
			}
			commonIndex ++;
		}
		
		if(commonIndex == -1)
			return "";
	return strs[0].substring(0, commonIndex+1);
		
    }

boolean getSameChar(String[] strs, int i)
{
	
	for(int j = 0 ; j < strs.length - 1; j++)
	{
		if( ( strs[j].charAt(i) ^ strs[j+1].charAt(i)) != 0)
			return false;
	}
	
	return true;
}

public String longestCommonPrefix2(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);             
        }
    }
    return strs[0];
}
	
}
