public class AnagramMinSteps {

	public static void main(String [] args)
	{
		String s = "leetcode";
		String t = "practice";
		
		AnagramMinSteps minSteps = new AnagramMinSteps();
		System.out.println(minSteps.minSteps(s, t));
		
	}
	
	 public int minSteps(String s, String t) {
	        
		 if(s == null || t == null)
		 {
			 return 0;
		 }
	        
		 if(s.length() != t.length())
		 {
			 return 0;
		 }
		 
		 int cumulativeSum = 0;
		 
		 // Two arrays to hold index info 
		 int[] sArray = new int[255];
		 int[] tArray = new int[255];
		 
		 for(int i = 0; i< s.length(); i++)
		 {
			 sArray[s.charAt(i)] ++;
			 tArray[t.charAt(i)] ++;
		 }
		
		 
		 // Now compare nums and get sum 
		 
		 for(int i = 0; i< 255; i++)
		 {
			 cumulativeSum += Math.abs(sArray[i] - tArray[i]);
		 }
		 
		 
		 cumulativeSum = cumulativeSum / 2;
		 
		 return cumulativeSum;
		 
		 
	}
	
}
