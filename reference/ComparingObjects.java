import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class PersonA implements Comparable<PersonA>
{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonA other = (PersonA) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	private String name;
	
	public String getName() {
		return name;
	}

	PersonA(String name)
	{
		this.name = name;
	}

	public int compareTo(PersonA o) {
		// TODO Auto-generated method stub
		//return -name.compareTo(o.name);
		
		int len1 = name.length();
		int len2 = o.name.length();
		
		if(len1 == len2)
		{
			return name.compareTo(o.name);
		}
		if(len1 > len2)
			return 1;
		
		return -1;
	}
	
	
}

public class ComparingObjects {
	
	
	
	public static void main(String [] args)
	{
		List<PersonA> list = new ArrayList<PersonA>();
		SortedSet<PersonA> set = new TreeSet<PersonA>();
		//Set<PersonA> set = new HashSet<PersonA>();
		
		addElements(list);
		addElements(set);
		Collections.sort(list);
		printElements(list);
		System.out.println("\n");
		printElements(set);
	
	}
	
	static void addElements(Collection<PersonA> coll)
	{
		coll.add(new PersonA("Tom"));
		coll.add(new PersonA("Amitabh"));
		coll.add(new PersonA("Bob"));
		coll.add(new PersonA("Dinesh"));
		coll.add(new PersonA("Sachinil"));
		coll.add(new PersonA("Sachinil"));
	}

	static void printElements(Collection<PersonA> coll)
	{
		for(PersonA p : coll)
		{
			System.out.println(p.getName());
		}
	}
	
}
