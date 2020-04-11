import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

	public static void main(String [] args)
	{
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		testMap(treeMap);
	}
	
	
	public static void testMap(Map<Integer, String> map)
	{
		map.put(9,"fox");
		map.put(6,"cat");
		map.put(1,"Lion");
		map.put(4,"Dog");
		map.put(7,"Wolf");
		map.put(5,"Goat");
		
		
		System.out.println(map);
		
		/*for(Integer key : map.keySet())
		{
			System.out.println("Key "+key+" Value "+map.get(key));
		}*/
		
	}
	
}
