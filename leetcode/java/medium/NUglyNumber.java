
public class NUglyNumber {
	
	public static void main(String [] args)
	{
		NUglyNumber num = new NUglyNumber();
		System.out.println(num.nthUglyNumber(10));
		
	}
	
	
	public int nthUglyNumber(int n) {
        
        if(n == 1)
            return n;
        
        int counter = 1;
        
        int number = 1;
        
        while(counter < n)
        {
        	number++;
        	
            if(number %2 == 0 || number % 3 == 0 || number % 5 == 0)
            {
                counter++;
            }
            
            
        }
        
        return number;
    }
}
