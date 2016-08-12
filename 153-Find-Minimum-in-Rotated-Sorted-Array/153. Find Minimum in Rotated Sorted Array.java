public class Solution {
    // 我的算法
	public int findMin(int[] nums) 
	{
		int pre = nums[0];
		// 找到第一个比前面元素小的就是最小的
        for(int i=1;i<nums.length;i++)
        {
        	if(nums[i] < pre)
        		return nums[i];
        	pre = nums[i];
        }
        // 如果没有找到则说明第一个元素就是最小的，数组没有旋转过
        return nums[0];
    }
}