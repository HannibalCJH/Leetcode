public class Solution {
    // 我的算法
	public int findKthLargest(int[] nums, int k) 
	{
        Arrays.sort(nums);
	    return nums[nums.length - k];
    }
}