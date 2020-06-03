package gfg;
/**
 * Given a binary number, write a program that prints 1 if given binary number is a multiple of 3.  Else prints 0. The given number can be big upto 2^100. It is recommended to finish the task using one traversal of input binary string.

Input:
Each case contains a string containing 0's and 1's.

Output:
For each test case, output a 1 if string is multiple of 3, else 0.
 * @author vpatil
 *
 */
public class BinaryDivisible3 {

	public static void main(String [] args)
	{
		BinaryDivisible3 bd3 = new  BinaryDivisible3();
		
		String input = "10101";
		
		System.out.println(bd3.isDivisibleByThree(input));
	}
	
	
	public boolean isDivisibleByThree(String input)
	{
		if(input == null || input.length() == 0)
			return false;
		
		int remState = 0;
		
		for(int i=0; i< input.length(); i++)
		{
			char c = input.charAt(i);
			
			switch(remState)
			{
				case 0:
					remState = (c == '0') ? 0: 1;
				break;
				case 1:
					remState = (c == '0') ? 2: 0;
				break;
				case 2:
					remState = (c == '0') ? 1: 2;
				break;
			
			}
			
			
		}
		
		System.out.println("Remstate "+remState);
		return remState == 0;
		
	}
	
}
