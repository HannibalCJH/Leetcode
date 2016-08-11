public class Solution {
    public int rob(int[] nums) 
    {
        // offset为0不抢最后一个房子，offset为1则抢最后一个房子
        return Math.max(robHelper(nums, 0), robHelper(nums, 1));
    }
    
    private int robHelper(int[] nums, int offset)
    {
        if(nums.length <= 1 + offset)
            return nums.length <= offset ? 0 : nums[0 + offset];
        
        int pre = nums[0 + offset];
        int cur = Math.max(nums[0 + offset], nums[1 + offset]);
        // 当不取最后一个房子时i<nums.length-1即不加最后一个nums[nums.length-1]
        // 取最后一个房子则i<nums.length
        for(int i = 2 + offset; i < nums.length - 1 + offset; i++)
        {
            int temp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = temp;
        }
        return cur;
    }
}