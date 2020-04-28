
public class ExcelSheetColNumber {
	
	public static void main(String [] args)
	{
		ExcelSheetColNumber esc = new ExcelSheetColNumber();
		
		System.out.println(esc.titleToNumber("ZY"));
	}

	public int titleToNumber(String s) {
        
		if(s == null || s.length() == 0)
			return 0;
		
		int length = s.length();
		
		int sum = 0;
		
		int multiply = 1;
		
		for(int i = length -1; i >= 0; i--)
		{
			char c = s.charAt(i);
			// int power = length - 1 - i;
					
			if(c >= 'A' && c <= 'Z') // Valid range
			{
				int val = c - 'A' + 1;
				//int multiply = new Double(Math.pow(26, power)).intValue();
				sum += val * multiply;
				
			}
			else
			{
				return 0;
			}
			
			multiply *= 26;
			
		}
		
		return sum;
        
    }

}
