public class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> locs;
    Random rand = new Random();
    
    // 构造函数
    /** Initialize your data structure here. */
    public RandomizedSet() 
    {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) 
    {
    	// 要加入的元素已存在则返回假
        if(locs.containsKey(val)) 
        	return false;
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) 
    {
    	// 要删除的元素不存在则返回假
        if(!locs.containsKey(val)) 
        	return false;
        int loc = locs.get(val);
        if(loc < nums.size() - 1) 
        { 
        	// not the last one then swap the last one with this val
            int lastOne = nums.get(nums.size() - 1);
            nums.set(loc , lastOne);
            locs.put(lastOne, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() 
    {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */