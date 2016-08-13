public class Solution {
    
    public void rotate(int[] nums, int k)
    {
        int length = nums.length;
        int step = k % length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, step);
        reverse(nums, step + 1, length - 1);
    }
    
    private void reverse(int[] nums, int i, int j)
    {
        while(i < j)
        {
            // 交换两个数
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    
    // 我的算法
    public void rotate2(int[] nums, int k) 
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