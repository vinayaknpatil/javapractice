
public class DetectCapital {

	public static void main(String [] args)
	{
		DetectCapital dc = new DetectCapital();
		
		String word = "Ff";
		
		System.out.println(dc.detectCapitalUse(word));
	}
	
public boolean detectCapitalUse(String word) {
     
	if(word == null || word.length() == 0)
		return false;
	
	
	boolean firstCap = false;
	int numLcase = 0;
	int upperCase = 0;
	
	char[] wchar = word.toCharArray();
	
	char c = wchar[0];
	
	if(c >= 'A' && c <= 'Z' )
	{
		firstCap = true;
		upperCase ++;
	}
	else
	{
		numLcase ++;
	}
	
	
	for(int i= 1; i< word.length(); i++)
	{
		char t = wchar[i];
		
		if(firstCap)
		{
			if( t >= 'A' && t <= 'Z')
			{
				if(numLcase > 0)
					return false;
				
				upperCase ++;
			}
			else if( t >= 'a' && t <= 'z')
			{
				if(upperCase > 1)
					return false;
				
				numLcase ++;
			}
			
		}
		else
		{
			if(( t >= 'A' && t <= 'Z'))
				return false;
			
			numLcase ++;
		}
		
	}
	
	return true;
	
    }


public boolean detectCapitalUse2(String word)
{
	if(word == null || word.length() == 0)
		return false;
	
	int numCaps = 0;
	
	for(int i=0; i< word.length();i++)
	{
		if(Character.isUpperCase(word.charAt(i)))
			numCaps++;
	}
	
	if(numCaps == 0 || numCaps == word.length())
		return true;
	
	if(numCaps == 1 && Character.isUpperCase(word.charAt(0)))
		return true;
	
	return false;
}
	

}
