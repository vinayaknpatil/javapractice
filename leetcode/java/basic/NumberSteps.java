/**
Given a non-negative integer num, return the number of steps to reduce it to zero. If the current number is even, 
you have to divide it by 2, otherwise, you have to subtract 1 from it.


  **/
public class NumberSteps {

	 public static void main(String [] args)
	 {
		 NumberSteps steps = new NumberSteps();
		 
		 System.out.println(steps.numberOfSteps(1233343522));
		 
	 }
	
	
	 public int numberOfSteps (int num) {
	     
		 if(num <=0)
			 return 0;
		 
		 if(num % 2 == 0)
		 {
			return 1 + numberOfSteps(num/2);
		 }
		 else
		 {
			 return 1 + numberOfSteps(num - 1);
		 }
		 
	}
	
}

