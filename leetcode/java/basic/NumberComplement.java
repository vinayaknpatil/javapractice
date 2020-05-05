
public class NumberComplement {

	public static void main(String [] args)
	{
		
		NumberComplement nc = new NumberComplement();
		
		System.out.println(nc.findComplement(9));
	}
	
	public int findComplement(int num) {
        
		 if(num == 0)
	            return 1;
		
		int comp = 1;
		
		int number = num;
		
		while(number > 0 )
		{
			number = number >> 1;
			comp = comp << 1;
		}
		
		
		comp = comp -1;
		
		return num ^ comp;
    }
}
