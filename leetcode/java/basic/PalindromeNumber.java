
public class PalindromeNumber {
	
	 public static void main(String [] args)
	 {
		 PalindromeNumber pn = new PalindromeNumber();
		 int x = 10;
		 
		 System.out.println(pn.isPalindrome(x));
	 }
	
	 public boolean isPalindrome(int x) {
	     
	        if(x < 0 )
	            return false;
	        
	        String s = String.valueOf(x);
	        
	        int sLen = s.length();
	        
	        int start = 0;
	        int end = sLen - 1;
	        
	        while(start <= end)
	        {
	            if(s.charAt(start) != s.charAt(end))
	                return false;
	            
	            start++;
	            end --;
	        }
	        
	        return true;
	    }
}
