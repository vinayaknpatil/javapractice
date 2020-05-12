
public class IsPerfectSquare {
	public boolean isPerfectSquare(int num) {
        if(num < 2)
        	return true;
		
		long square = 1;
        
		long start = 1;
		
		long end = num/2;
    
		
		while(start <= end)
		{			
			long index = start + (end-start)/2;
			
			square = index * index;
			
			if(square == num)
				return true;
			
			if(square < num) // Need to increase the value 
			{
				start = index + 1;
			}
			else
			{
				end = index -1;
			}
			
		}
       
		return false;
    }
}
