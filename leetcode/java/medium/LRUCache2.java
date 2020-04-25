import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache2 {

	public static void main(String args[])
	{
		LRUCache2 cache = new LRUCache2(4);
		
		System.out.println(cache.get(1));
		
		cache.put(1, 50);
		cache.put(2, 30);
		cache.put(3, 80);
		
		System.out.println(cache.get(1));
		cache.put(4, 60);
		cache.put(5, 70);
		
		System.out.println(cache.get(2));
		
	}
	
	  final int limit;
	  
	  LinkedHashMap<Integer, Integer> hashMap;
	  
	  public LRUCache2(int capacity) {
		    
	        this.limit = capacity;
	        hashMap = new LinkedHashMap<>();
	        
	    }
	  
	  public int get(int key) {
		  
		  if(hashMap.containsKey(key))
		  {
			  int value = hashMap.get(key);
			  
			  hashMap.remove(key);
			  hashMap.put(key, value);
			  
			  return value;
		  }
		  
		  return -1;
		  
	  }
	  
	  public void put(int key, int value) {
		  
		  if(hashMap.containsKey(key))
		  {
			  hashMap.remove(key);
			  hashMap.put(key, value);
		  }
		  else
		  {
			  if(hashMap.size() >= limit)
			  {
				 Iterator<Entry<Integer, Integer>> itr = hashMap.entrySet().iterator();
				 
				 Entry<Integer, Integer> entry = itr.next();
				 hashMap.remove(entry.getKey());
				 
			  }
			  
			  hashMap.put(key, value);
		  }
			
		  
	  }
}

