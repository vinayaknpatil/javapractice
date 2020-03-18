public class ReverseInteger
{
	
	public static void main(String[] args)
	{
		ReverseInteger ri = new ReverseInteger();
		
		int res = ri.reverse(-120);
		
		System.out.println(res);
	}
	
	
	public int reverse(int x) {
	    
		boolean negative = (x < 0);
		
		if(negative)
			x = -x;
		
		long output = 0;
		 
		 while(x > 0)
		 {
			 int rem = x % 10;
			 
			 output = output * 10 + rem;
			 
			// System.out.println(output);
			 
			if(output > Integer.MAX_VALUE)
			{
				return 0;
			}
			 x  = x/10;
		 }
		 
		
		if(negative)
		{
			output = - output;
		}
		
		return new Long(output).intValue();
	}

}
