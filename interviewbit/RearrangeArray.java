/**
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]
Return : [0, 1]
 Lets say N = size of the array. Then, following holds true :
All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer
 */
import java.util.ArrayList;

public class RearrangeArray {
	
	public static void main(String [] args)
	{
		ArrayList<Integer> input = new ArrayList<>();
		input.add(3);
		input.add(0);
		input.add(1);
		input.add(4);
		input.add(2);
		
		RearrangeArray obj = new RearrangeArray();
		obj.arrange(input);
		
		for(int i: input)
			System.out.println(i);
	}

	
	 public void arrange(ArrayList<Integer> a) {
		 
		 if(a == null || a.size() == 0)
			 return;
		 
		 Integer[] result = new Integer[a.size()];
		 
		 for(int i = 0; i<a.size(); i++)
		 {
			 int number = a.get(i);
			 
			 result[i] = a.get(number);
		 }
		
		 for(int i = 0; i<result.length; i++)
		 {
			 a.set(i, result[i]);
		 }
		 
	   }
}
