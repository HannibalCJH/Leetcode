public class Solution {
    public int[] productExceptSelf(int[] nums) 
	{
        int[] res = new int[nums.length];
        res[res.length - 1] = 1;
        // res[i]为nums[i]右半边所有元素之积
        for(int i = nums.length - 2; i >= 0; i--)
            res[i] = res[i+1] * nums[i+1];
        
        int left = 1;
        // left为nums[i]左半边元素之积
        for(int i = 0; i < nums.length; i++) 
        {
            res[i] *= left;
            left *= nums[i];
        }
        return res;
    }
}