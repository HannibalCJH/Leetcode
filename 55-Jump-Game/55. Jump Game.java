public class Solution {
    public boolean canJump(int[] nums) 
    {
        if(nums.length <= 1)
            return true;
            
        int maxReach = 0;
        for(int i = 0; i < nums.length; i++)
            if(i <= maxReach)
                maxReach = Math.max(maxReach, i + nums[i]);
        return maxReach >= nums.length - 1;
    }
}