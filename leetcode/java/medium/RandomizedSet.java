/**
 * Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
Map<Integer,Integer> lookupMap;
    
    List<Integer> dataList;
    
    Random random = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        lookupMap = new HashMap<Integer,Integer>();
        dataList = new ArrayList<Integer>();
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(!lookupMap.containsKey(val))
        {
            dataList.add(val);
            lookupMap.put(val, dataList.size()-1);
            
            return true;
        }

        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if(!lookupMap.containsKey(val))
            return false;
        
        int index = lookupMap.get(val);
        
        lookupMap.remove(val);
        
        dataList.set(index, dataList.get(dataList.size() -1 ));
        
        int rep = dataList.get(index);
        
        dataList.remove(dataList.size() -1);
        
        if(lookupMap.containsKey(rep))
            lookupMap.put(rep, index);
        
        return true;
        
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int len = dataList.size();
        
        int index = random.nextInt(len);
        return dataList.get(index);
    }
}
