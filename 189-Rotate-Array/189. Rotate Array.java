public class Solution {
    // 我的算法
    public void rotate(int[] nums, int k) 
    {
        if(nums.length == 0)
            return;
        
        int len = nums.length;
        int step = k % len;
        int[] temp = new int[step];
        int index = len - 1;
        
        for(int i = step - 1; i >= 0; i--)
            temp[i] = nums[index--];
        
        int i = len - 1;
        while(index >= 0)
            nums[i--] = nums[index--];
        for(int j = 0; j < step; j++)
            nums[j] = temp[j];
    }
}