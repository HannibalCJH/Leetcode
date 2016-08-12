public class Solution {
    public int findPeakElement(int[] nums) 
    {
        int left = 0, right = nums.length - 1;
        while(left < right)
        {
            int mid = (left + right) / 2;
            // 左右边界相邻
            if(left == mid)
                return nums[left] < nums[right] ? right : left;
            if(nums[mid] < nums[mid + 1])
                left = mid;
            if(nums[mid] > nums[mid + 1])
                right = mid;
        }
        return 0;
    }
}