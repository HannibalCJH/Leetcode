public class Solution {
    // 我的算法
	public int[] intersect(int[] nums1, int[] nums2) 
	{
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> intersection = new ArrayList<Integer>();
        // 扫描数组1
        for(int i = 0; i < nums1.length; i++)
        {
        	int key = nums1[i];
        	if(map.containsKey(key)) 
        		map.put(key, map.get(key) + 1);
        	else
        		map.put(key, 1);
        }
        
        // 扫描数组2
        for(int i = 0; i < nums2.length; i++)
        {
        	int key = nums2[i];
        	// 数组1里有该元素
        	if(map.containsKey(key))
        	{
        		intersection.add(key);
        		// 该元素个数减1
        		int val = map.get(key) - 1;
        		// 数组1里该元素个数减到0则删除该元素
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