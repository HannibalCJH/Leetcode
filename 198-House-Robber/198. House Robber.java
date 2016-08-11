public class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        
        int pre = nums[0];  // 没有加nums[i-1]
        int cur = Math.max(nums[0], nums[1]);  // 当前最大，可能加了nums[i-1]
        for(int i = 2; i < nums.length; i++)
        {
            // 记录当前最大
            int temp = cur;
            // 比较当前最大和pre加上nums[i](注意pre是没有加上nums[i-1]，这样保证是最起码隔了一座房子)
            cur = Math.max(cur, pre + nums[i]);
            // 把pre设成temp，这是在没有考虑nums[i]之前的最大值
            pre = temp;
        }
        return cur;
    }
}