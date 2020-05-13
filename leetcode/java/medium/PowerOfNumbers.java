public class PowerOfNumbers {
	
	public static void main(String [] args)
	{
		PowerOfNumbers pon = new PowerOfNumbers();
		
		//double input = 0.5;
		//int n = 3;
		
		double input = 1.72777;
				
		int n = 7;
		
		
		//System.out.println(pon.myPow(20.0000, -2147483648));
		
		System.out.println(pon.myPow(input, n));
	}

	public double myPow(double x, int n) {
		
		if(n == 0)
			return 1;
		
		if(n==1)
			return x;
		
		double retValue = x;
		double resultValue = 1;
		
		long counter = 1;
		
		long num = n;
		boolean isNegativeIndex = false;
		
		if(num < 0)
			isNegativeIndex = true;
		
		num = Math.abs(num);
		
		
		while(num > 0 )
		{
			if(num >= counter * 2)
			{
				retValue = retValue * retValue;
				
				counter = counter * 2;
				
				//num = num - counter;
			}
			else
			{
				num = num - counter;
				resultValue = resultValue * retValue;
				counter = 1;
				retValue = x;
			}	
			
		}
		
		return isNegativeIndex ? 1/resultValue: resultValue;
		
	}
	
	
	
	public double myPow2(double x, int n) {
        if (n < 0) return 1 / helper(x, n);
        return helper(x, n);
    }
    
    private double helper(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        return n % 2 == 0 ? helper(x * x, n / 2) : x * helper(x * x, n / 2);
    }
	
}