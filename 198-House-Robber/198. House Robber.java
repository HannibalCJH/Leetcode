public class Solution {
    public int rob(int[] nums) 
	{
		if(nums.length <= 1)
            return nums.length == 0 ? 0 : nums[0];
        // a是上次的最大收益
        int a = nums[0];
        // b是当前的最大受益
        int b = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++)
        {
            // 记录当前b
            int temp = b;
            // 当前的最大收益是两种选择里较大的那个
            b = Math.max(a + nums[i], b);
            // 把原来的b赋值给a，这样a就是没有加上nums[i]之前的值
            a = temp;
        }
        return b;
    }
}