/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
 * @author vpatil
 *
 */
public class FirstBadVersion {
	
	public static void main(String [] args)
	{
		FirstBadVersion fb = new FirstBadVersion();
		System.out.println(fb.firstBadVersion(2126753390));
	}

public int firstBadVersion(int n) {
        
        int start = 1;
        int end = n;
        int index = 1;
        
     
        
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            
            System.out.println("Index "+mid);
            
            if(isBadVersion(mid)) // Its bad - so need to search prior 
            {
            	 index = mid;
                 end = mid-1;
            }
            else // Its good, so look at right side 
            {
                start = mid+1;
            }
            
        }
        
        return index;
     
    }

	boolean isBadVersion(int n)
	{
		int badVersion = 1702766719;
		if(n >= badVersion)
			return true;
		
		return false;
	}
}
