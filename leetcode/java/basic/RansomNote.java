/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 * @author vpatil
 *
 */
public class RansomNote {

public boolean canConstruct(String ransomNote, String magazine) {
        
        if(magazine == null || ransomNote == null)
            return false;
        
        
        int[] lookup = new int[255];
        
        for(int i=0; i< magazine.length(); i++)
        {
            int index = magazine.charAt(i);
            
            lookup[index] = lookup[index]+1;
            
        }
        
        for(int i=0; i< ransomNote.length(); i++)
        {
            int index = ransomNote.charAt(i);
            
            if(lookup[index] == 0)
                return false;
            
            lookup[index] = lookup[index]-1;
        }
        
        return true;
        
    }
	
	
}
