public class Solution {
    public int findPeakElement(int[] nums) 
	{
		int left = 0, right = nums.length - 1;
		while(left < right)
		{
			int mid = left + (right - left) / 2;
			// 左右边界挨着
			if(left == mid)
				return nums[left] < nums[right] ? right : left;
			// 如果右边是上坡，则抛弃左边，设left等于mid
			left = nums[mid] < nums[mid + 1] ? mid : left;
			// 如果左边是上坡，则抛弃右边边，设right等于mid
			right = nums[mid] > nums[mid + 1] ? mid : right;
		}
		
		return 0;
    }
}