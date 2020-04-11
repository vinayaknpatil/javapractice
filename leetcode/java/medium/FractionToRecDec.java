/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"

 */
import java.util.ArrayList;

//import java.util.LinkedHashSet;

public class FractionToRecDec {

	public static void main(String [] args)
	{
		int num = -50;
		int den = 8;
		
		FractionToRecDec fr = new FractionToRecDec();
		System.out.println(fr.fractionToDecimal(num, den));
	}
	
	
	 
	
public String fractionToDecimal(int numerator, int denominator) {
        
		long numLong = numerator;
		long denLong = denominator;
	
		if (numLong == 0)
			return "0";
		
		if(denLong == 0)
			return null;
		
		boolean isNegative = false;
		
		System.out.println("Num "+numLong+" Deno "+denLong);
		
		if( (numLong > 0 && denLong > 0) || (numLong < 0 && denLong < 0))
			
		{
			System.out.println("Is not negative");
			isNegative = false;
		}
		else
		{
			System.out.println("Is negative");
			isNegative = true;
		}
		
		if(numLong < 0)
			numLong = -numLong;
		
		if(denLong < 0)
			denLong = -denLong;
		
		StringBuffer result = new StringBuffer();
		
		long integerPart = numLong/denLong;
		
		if(isNegative)
			result.append("-");
		
		result.append(integerPart);
		
		long remainder = numLong%denLong;
		
		if(remainder == 0)
			return result.toString();
		
		result.append(".");
		
		boolean repeat = false;
		
		ArrayList<Long> remainderList = new ArrayList<>();
		//ArrayList<Long> numList = new ArrayList<>();
		
		System.out.println(result);
		int rStartIndex = 0;
				
		StringBuffer fractionPart = new StringBuffer();
		
		//System.out.println("Numerator "+numLong+" Denominator "+numLong);
		remainder *= 10;
		remainderList.add(remainder);
		
		while(remainder != 0)
		{
			//System.out.println("Remainder "+remainder);
			
			if(remainder > denLong)
			{
				long frac = remainder/denLong;
				
				remainder = remainder % denLong;
				
				fractionPart.append(frac);
				remainder *= 10;
			}
			else
			{
				remainder *= 10;
				fractionPart.append("0");
			}
			
			
			//System.out.println("Num "+num +" Frac  "+frac+" Remainder "+remainder);
			
			if(remainderList.indexOf(remainder) != -1)
			{
				rStartIndex = remainderList.indexOf(remainder);
				repeat = true;
				break;
				
			}
			else
			{
				remainderList.add(remainder);
			}
		}
	
		if(!repeat)
		{
			return result.append(fractionPart).toString();
			
		}
		else
		{
			fractionPart.insert(rStartIndex, "(");
			fractionPart.append(")");
			return result.append(fractionPart).toString();
		}
		
		
		}
	
    }


// Map would make it faster

/*public String fractionToDecimal(int num, int deno) {
    if(num == 0)
       return "0";

   StringBuilder result = new StringBuilder();
    result.append(((num>0)^(deno>0)) ? "-" : "");

   long n = Math.abs((long)num);
   long d = Math.abs((long)deno);

   result.append(String.valueOf(n/d));
   d = Math.abs(d);
   long rem = Math.abs(n%d);

   if(rem == 0){
       return result.toString();
   }
   result.append(".");
   Map<Long,Integer> map = new HashMap();
   rem*=10;
   map.put(rem,(int)result.length());
   while(rem!=0){

       if(rem>=d){
           result.append(String.valueOf(rem/d));
           rem%=d;
           rem*=10;
       }else{
           rem*=10;
           result.append("0");
       }

       int index = map.getOrDefault(rem, -1);
       if(index != -1){ //If true parenthesize the occurence and break.
           result.insert(index,"(");
           result.insert(result.length(),")");
           break;
       }else{
          map.put(rem,result.length());
       }
   }

 return result.toString();
} */
