/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @author vpatil
 *
 */

public class MultiplyStrings {
	
	public static void main(String [] args)
	{
		MultiplyStrings ms = new MultiplyStrings();
		
		String s1 = "11233";
		String s2 = "455564";
		
		System.out.println(ms.multiply(s1, s2));
	}

	public String multiply(String num1, String num2) {
	     
        if(num1 == null || num1.length() == 0)
            return num2;
        
        if(num2 == null || num2.length() == 0)
            return num1;
        
        
      // StringBuffer result = new StringBuffer();
        
        int n1Length = num1.length();
        int n2Length = num2.length();
        
        Stack<String> result = new Stack<String>();
        
        if(n2Length >= n1Length) // Swap the strings
        {
        	String temp = num2;
        	num2 = num1;
        	num1 = temp;
        	
        	n1Length =  num1.length();
        	n2Length = num2.length();
        	
        }
        
        Map<Integer, String> mapping = new HashMap<Integer, String>();
        
        for(int i=n2Length-1; i >=0 ; i--)
           {
        		int m = new Integer(num2.charAt(i) -48);
        		StringBuffer res = null;
        		
        		if(mapping.get(m) == null)
        		{
        			res = getMultiply(num1, m);
                    
        			mapping.put(m, res.toString());
        			
                    for(int j = 0; j< n2Length -1 - i; j++)
                        res.append(0);
                    
                    
        		}
        		else
        		{
        			res = new StringBuffer(mapping.get(m));
        			
        			for(int j = 0; j< n2Length -1 - i; j++)
                        res.append(0);
        		}
        	
                               
              //  System.out.println("Product of "+num1+ " and "+num2.charAt(i)+" is "+res.toString());
                
                result.push(res.toString());
            }
            
            
                   
        StringBuffer finalRes = new StringBuffer();
        
        while(!result.isEmpty())
        {
            String s1 = result.pop();
            
            if(result.isEmpty())
            {
               finalRes = new StringBuffer(s1);
               break;
            }
            result.push( add (s1, result.pop()));
        }
        
                
        for(int i = 0; i < finalRes.length();i++)
        {
        	if(finalRes.charAt(i) == '0')
        	{
        		finalRes.deleteCharAt(i);
        		i--;
        	}
        	else
        		break;
        	
        }
        	
        if(finalRes.length() == 0)
        	finalRes.append("0");
        
      //  System.out.println("Final Result "+finalRes.toString());
        return finalRes.toString();
    }
    
    
    private String add(String s1, String s2)
    {
        int carryOver = 0;
        
        StringBuffer addRes = new StringBuffer();
        
        int s1Index = s1.length()-1;
        int s2Index = s2.length()-1;
        
        while(true)
        {
            if(s1Index < 0 && s2Index < 0)
                break;
            
            int one = 0;
            int two = 0;
            
            if(s1Index >= 0)
            {
                one = new Integer(s1.charAt(s1Index) -48);
                s1Index --;
            }
            
            if(s2Index >= 0)
            {
                two = new Integer(s2.charAt(s2Index) -48);
                s2Index--;
            }
            
            int sum = one+two+carryOver;
            
            carryOver = sum / 10;
            
            int val = sum % 10;
            
            addRes.insert(0, val);
                     
        }
        
        addRes.insert(0,carryOver);

       
        return addRes.toString();
        
    }
    
    private StringBuffer getMultiply(String s, int num)
    {
        if(num == 0)
            return new StringBuffer("0");
        
        if(num == 1)
            return new StringBuffer(s);
        
        
       // System.out.println("S= "+s +" and num = "+num);
        
        int carryOver = 0;
        
        StringBuffer product = new StringBuffer();
        
        for(int i=s.length() - 1; i >=0 ; i--)
        {
            Integer one = new Integer(s.charAt(i) - 48);
            
            int prod = (one * num) + carryOver;
            
           // System.out.println(one+" -- "+num+"--"+prod);
            
            carryOver = prod/10;
            
            int val = prod%10;
            
            product.insert(0,val);
            
        }
        
        product.insert(0,carryOver);
        
        return product;
    }
    
    
    
    public String multiply2(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] product = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int p = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int pos1 = i + j + 1;
                int pos2 = i + j;
                int sum = p + product[pos1];
                product[pos1] = sum % 10;
                product[pos2] += sum / 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < product.length; i++) {
            if (builder.length() == 0 && product[i] == 0) continue;
            builder.append(product[i]);
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }
	
}

