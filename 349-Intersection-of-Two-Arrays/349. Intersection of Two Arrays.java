public class Solution {
    // 我的算法
	public int[] intersection(int[] nums1, int[] nums2) 
    {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> intersection = new HashSet<Integer>();
        // 扫描数组1
        for(int i = 0; i < nums1.length; i++)
        	set.add(nums1[i]);
        // 扫描数组2并找出交集
        for(int i = 0; i < nums2.length; i++)
        	if(set.contains(nums2[i]))
        		intersection.add(nums2[i]);
        int[] result = new int[intersection.size()];
        int index = 0;
        for(Integer in : intersection)
        	result[index++] = in;
        return result;
    }
}