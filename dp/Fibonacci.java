public class Fibonacci {

	static int[] lookup = new int [1000];
	
	public static void main(String [] args)
	{
		for(int i = 0; i < 1000; i++)
			lookup[i] = -1;
		
		
		System.out.println("Fib value for 40 "+computeFib(40));
		
		for(int i=0; i< 51; i++)
		{
			System.out.println(lookup[i]);
		}
	}
	
	
	static int computeFib(int n)
	{
		if(lookup[n] == -1)
		{
			if(n <= 1)
				lookup[n] = n;
			else
				lookup[n] = computeFib(n -1 )+ computeFib(n-2);
		}
		
		return lookup[n];
	}
}
