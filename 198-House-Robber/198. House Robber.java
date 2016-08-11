public class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        
        int pre = nums[0], cur = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++)
        {
            int temp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = temp;
        }
        return cur;
    }
}