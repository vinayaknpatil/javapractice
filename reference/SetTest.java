import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String [] args)
	{
		Set<String> set1 = new HashSet<String>();
		
		// Set<String> set1 = new LinkedHashSet<String>();
		
		//Set<String> set1 = new TreeSet<String>();
		
		/*if(set1.isEmpty())
			
		{
			System.out.println("Set 1 is empty");
		}
		*/
		
		set1.add("dog");
		set1.add("cat");
		set1.add("fox");
		set1.add("wolf");
		set1.add("dog");
		set1.add("lion");
		
		System.out.println(set1);
		
		/*for(String str: set1)
		{
			System.out.println(str);
		}*/
			
		//System.out.println(set1.contains("cet"));
		
		//System.out.println(set1.contains("dog"));
		
		/*Object [] array = set1.toArray();
		
		for(int i=0; i< array.length; i++)
		{
			System.out.println(array[i]);
		}
		*/
		
		
		Set<String> set2 = new TreeSet<String>();
		
					
		set2.add("dog");
		set2.add("cat");
		set2.add("tiger");
		set2.add("giraffe");
		set2.add("monkey");
		set2.add("ant");
		
		
		Set<String> intersection = new HashSet<String>(set1);
		System.out.println(intersection);
		
		intersection.retainAll(set2);
		
		
		System.out.println(intersection);
		
		
		// Difference 
		
		Set<String> difference = new HashSet<String>(set1);
		
		difference.removeAll(set2);
		
		System.out.println(difference);
		
		List<String>  list = new ArrayList<String>();
		
		
		
		
	}
	
}
