public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) 
	{
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> intersection = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
        	int key = nums1[i];
        	if(map.containsKey(key)) 
        		map.put(key, map.get(key) + 1);
        	else
        		map.put(key, 1);
        }
        
        for(int i = 0; i < nums2.length; i++)
        {
        	int key = nums2[i];
        	if(map.containsKey(key))
        	{
        		intersection.add(key);
        		int val = map.get(key) - 1;
        		if(val < 1)
        			map.remove(key);
        		else
        			map.put(key, val);
        	}
        }
        
        int[] result = new int[intersection.size()];
        for(int i = 0; i < result.length; i++)
        	result[i] = intersection.get(i);
        return result;
    }
}