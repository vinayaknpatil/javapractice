public class JewelsStones {

	public static void main(String [] args)
	{
		JewelsStones stones = new JewelsStones();
		String J = "z";
		String S =  "ZZ";
		
		System.out.println(stones.numJewelsInStones(J, S));
	}
	
public int numJewelsInStones(String J, String S) {
		int count = 0;
		
		char[] jewels = new char[255];
		
		if(J == null || J.trim().length() == 0)
			return 0;
		
		if(S == null || S.trim().length() == 0)
			return 0;
	
	
		for(char c:J.toCharArray())
		{
			jewels[c] = 1;
		}
		
		
		for(char s:S.toCharArray())
		{
			if(jewels[s] == 1)
				count ++;
		}
		
		return count;
		
    }

public int numJewelsInStones2(String J, String S)
{
	int count = 0;
	
	for(char c: S.toCharArray())
	{
		if(J.indexOf(c) > - 1)
		{
			count ++;
		}
	}
	
	return count;
}
	
}
