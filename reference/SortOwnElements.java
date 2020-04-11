import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SortOwnElements {

	
	
	
	public static void main(String [] args)
	{
		Person p1 = new Person(0, "Ramesh");
		Person p2 = new Person(1, "Suresh");
		Person p3 = new Person(2, "Rahul");
		Person p4 = new Person(1, "Suresh");
		
		Map<Person, Integer> map = new LinkedHashMap<Person, Integer>();
		
		map.put(p1, 1);
		map.put(p2, 2);
		map.put(p3, 3);
		map.put(p4, 4);
		
		System.out.println(map);
		
		Set<Person> set = new LinkedHashSet<Person>();
		
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		
		System.out.println(set);
		
	}
}

class Person
{
	private int id;
	private String name;
	
	public Person(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public String toString()
	{
		return id+":"+name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
