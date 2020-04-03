import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GroupAnagrams {

	
	 public List<List<String>> groupAnagrams(String[] strs) {
	        
	        // Loop thru all . Sort the characters and check if present in map . If so add it 
	        // to the list 
	        
	        List<List<String>> output = new ArrayList<List<String>>();
	        
	        if(strs == null || strs.length == 0)
	            return output;
	        
	        
	        Map<String, List<String>> map = new HashMap<String, List<String>>();
	        
	        for(String input: strs)
	        {
	            
	            char[] data = input.toCharArray();
	            Arrays.sort(data);
	            String temp = new String(data);
	            
	            if(map.get(temp) == null)
	            {
	                List<String> list = new ArrayList<String>();
	                list.add(input);
	                map.put(temp, list);
	            }
	            else
	            {
	                List<String> list = map.get(temp);
	                list.add(input);
	            }
	            
	        }
	        
	        // Now loop through the map and add to the result 
	        
	        for(String key: map.keySet())
	        {
	            output.add(map.get(key));
	        }
	        
	        return output;
	        
	    }
}
