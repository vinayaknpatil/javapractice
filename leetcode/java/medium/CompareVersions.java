
public class CompareVersions {

		public static void main(String [] args)
		{
			CompareVersions cv = new CompareVersions();
			
			String version1 = "0.0";
			String version2 = "1.0";
			
			System.out.println(cv.compareVersion(version1, version2));
			
		}
	
	
	  public int compareVersion(String version1, String version2) {
	        
	        if(version1 == null && version2 == null )
	        	return 0;
	        
	        if(version1 == null && version2 != null)
	        	return -1;
	        
	        if(version1 != null && version2 == null)
	        	return 1;
	        
	        if(version1.equals(version2))
	        	return 0;
	        
	        
	        String[] v1Array = version1.split("\\.");  // The . needs to be escaped 
	        String[] v2Array = version2.split("\\.");
	        
	        int maxLength = Math.max(v1Array.length, v2Array.length);
	        
	        for(int i = 0; i< maxLength; i++)
	        {
	        	int one = 0;
	        	int two = 0;
	        	
	        	if(i < v1Array.length)
	        	{
	        		try
	        		{
	        			one = Integer.parseInt(v1Array[i].trim());
	        		}
	        		catch(NumberFormatException nex)
	        		{
	        			
	        		}
	        	}
	        	
	        	if(i < v2Array.length)
	        	{
	        		try
	        		{
	        			two = Integer.parseInt(v2Array[i].trim());
	        		}
	        		catch(NumberFormatException ex)
	        		{
	        			
	        		}
	        	}
	        	
	        	if(one < two)
	        		return -1;
	        	
	        	if(one > two)
	        		return 1;
	        	
	        }
	        
	        return 0;
	    }
}
