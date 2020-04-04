/**
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 
 * @author vpatil
 *
 */
import java.util.List;
import java.util.ArrayList;
public class HappyNumber {
public boolean isHappy(int n) {
        
        List<Integer> checkList = new ArrayList<Integer>();
        
        if( n == 1)
            return true;
        
              
        return checkIsHappy(n,checkList);
    }
    
    boolean checkIsHappy(int n,List<Integer> checkList )
    {
        if(n == 1)
            return true;
        
        if(checkList.contains(n))
        {
            return false;
        }
        
        checkList.add(n);
        
        int square = 0; 
        
        while(n > 0)
        {
            int digit = n%10;
            square += (digit * digit);
            n = n/10;
        } 
        
               
        return checkIsHappy(square, checkList);
        
    }

    
    public boolean isHappy2(int n) {
        if(n==1)
            return true;
         int slow, fast; 
         slow = fast = n; 
    do
    { 
        slow = func(slow); 
        fast = func(func(fast)); 
    } 
    while (slow != fast); 
    return (slow == 1); 
    }

    private int func(int n) 
{ 
    int squareSum = 0; 
    while (n!= 0) 
    { 
        squareSum += (n % 10) * (n % 10); 
        n /= 10; 
    } 
    return squareSum; 
} 
}

