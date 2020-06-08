
public class CheckPalindrome {
	
	public static void main(String [] args)
	{
		CheckPalindrome cp = new CheckPalindrome();
		System.out.println(cp.checkPalindrome("aaabaaaa"));
	}
	
	boolean checkPalindrome(String inputString) {
	    if(inputString == null || inputString.length() == 0)
	        return true;
	        
	    int i = 0;
	    int j = inputString.length() - 1;
	    
	    while(i < j)
	    {
	        if(inputString.charAt(i) != inputString.charAt(j))
	        {
	            return false;
	        }
	           
	        i++;
	        j--;
	    }
	    
	    return true;
	}
}
