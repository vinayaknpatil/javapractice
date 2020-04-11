import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSort {

	public static void main(String [] args)
	{
		List<String> animals = new ArrayList<String>();
		
		animals.add("tiger");
		animals.add("monkey");
		animals.add("cat");
		animals.add("lion");
		animals.add("panther");
		animals.add("deer");
		
		//Collections.sort(animals, new StringLengthComparator());
		Collections.sort(animals, new ReverseAlphabeticalComparator());
		
		//System.out.println(animals);
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(3);
		numbers.add(36);
		numbers.add(73);
		numbers.add(40);
		numbers.add(1);
		
		Collections.sort(numbers, new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return -o1.compareTo(o2);
			}
			
		});
		
		System.out.println(numbers);
		
	}
	
}

class ReverseAlphabeticalComparator implements Comparator<String>
{

	public int compare(String s1, String s2) {
		
		return s2.compareTo(s1);
	}
	
}


class StringLengthComparator implements Comparator<String>
{

	public int compare(String s1, String s2) {
		
		int len1 = s1.length();
		int len2 = s2.length();
		// TODO Auto-generated method stub
		
		if(len1 > len2)
			return 1;
		
		if(len1 < len2)
			return -1;
		
		return 0;
	}
	
}
