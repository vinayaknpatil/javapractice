import java.util.HashMap;
import java.util.Map;

/*
 * Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */
public class TrieDB {
	 /** Initialize your data structure here. */
	
	 public static void main(String [] args)
	    {
	    	TrieDB db = new TrieDB();
	    	
	    	//String word = "apple";
	    	
	    	db.insert("apple");
	    	db.insert("ibm");
	   
	    	System.out.println(db.startsWith("app"));
	    	
	    	System.out.println(db.search("ib"));
	    	
	    	System.out.println(db.search("apple"));
	    	
	    	System.out.println(db.search("ibm"));
	    	
	    	System.out.println(db.startsWith("i"));
	    	
	    }
	
	CharEntry trieDs;
	
    public TrieDB() {
        trieDs = new CharEntry();
        trieDs.setEntries(new HashMap<Character, CharEntry>());
    }
    
   
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
    	if(word == null || word.length() == 0)
    		return;
    	
    	CharEntry temp = trieDs;
    	
    	for(int i = 0; i< word.length(); i++)
    	{
    		Character c = word.charAt(i);
    		
    		CharEntry lookup = temp.getEntries().get(c);
    		
    		if(lookup == null)
    		{
    			lookup = new CharEntry();
    			lookup.setEntries(new HashMap<>());
    			temp.getEntries().put(c, lookup);
    		}
    		
    		temp = lookup;
    		
    		if(i == ( word.length() - 1))
    			temp.setEndNode(true);
    	}
    	
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	CharEntry temp = this.trieDs;
    	
    	for(int i=0; i< word.length(); i++)
    	{
    		Character key = word.charAt(i);
    		CharEntry entry = temp.getEntries().get(key);
    		
    		if(entry == null)
    			return false;
    		
    		temp = entry;
    		
    		if(i == (word.length() - 1) && !entry.isEndNode())
    			return false;
    	}
    	
    	return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
    	CharEntry temp = this.trieDs;
    	
    	for(int i=0; i< prefix.length(); i++)
    	{
    		Character key = prefix.charAt(i);
    		CharEntry entry = temp.getEntries().get(key);
    		
    		if(entry == null)
    			return false;
    		
    		temp = entry;
    	}
    	
    	return true;
    }
}

class CharEntry
{
	private Map<Character, CharEntry> entries;
	
	private boolean isEndNode;

	public Map<Character, CharEntry> getEntries() {
		return entries;
	}

	public void setEntries(Map<Character, CharEntry> entries) {
		this.entries = entries;
	}

	public boolean isEndNode() {
		return isEndNode;
	}

	public void setEndNode(boolean isEndNode) {
		this.isEndNode = isEndNode;
	}
	
	
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }
    
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        
        TrieNode() {
            children = new TrieNode[26];
        }
    }
}
