public class IntegerToRoman {

	public static void main(String [] args)
	{
		IntegerToRoman itr = new IntegerToRoman();
		System.out.println(itr.intToRoman(3890));
	}
	
	 public String intToRoman(int num) {
	  
		 StringBuffer roman = new StringBuffer();
		 
		 // Process in order 
		 
		 int value = getRomanRep(num,1000, 'M','C', roman, 900);
		 
		 value = getRomanRep(value,500, 'D','C', roman, 400);
		 
		 value =  getRomanRep(value,100, 'C','X', roman,90);
		 
		 value = getRomanRep(value,50, 'L','X', roman, 40);
		 
		 value = getRomanRep(value,10, 'X','I', roman, 9);
		 
		 value = getRomanRep(value,5, 'V','I', roman, 4);
		 
		 value = getRomanRep(value,1, 'I',' ', roman, 10);
		 
		 return roman.toString();
		 
	 }
	
	 
	 private int getRomanRep(int inputNumber, int divNumber, char rep, char upChar , StringBuffer roman, int modLimit)
	 {
		 
		 if(inputNumber == 0)
		 {
			 return 0;
		 }
		 
		 int rem = inputNumber/divNumber;
		 
		 
		 
		 for(int i = 0; i < rem; i++)
		 {
			 roman.append(rep);
		 }
		 
		 inputNumber = inputNumber - (rem * divNumber);
		 
		 if (inputNumber >= modLimit)
		 {
			 roman.append(upChar).append(rep);
			 
			 inputNumber = inputNumber - modLimit;
		 } 
		 
		 return inputNumber;
	 }

	  public String intToRoman2(int num) {
		 int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		 String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		 StringBuilder roman = new StringBuilder();
		 for(int i=0;i<values.length;i++){
		 while(num>=values[i]){
		 roman.append(romanLiterals[i]);
		 num-=values[i];
		 }

		     }
		     return roman.toString();
		 }

}
