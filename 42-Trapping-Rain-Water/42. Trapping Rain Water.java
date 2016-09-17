public class Solution {
    public int trap(int[] height) 
	{
        if(height == null || height.length == 0)
            return 0;
        
        int left = 0;
        int right = height.length - 1;
        int smaller;
        int area = 0;
        while(left < right) 
        {
        	// 短板效应，找左右边界较小的那个
            if(height[left] < height[right]) 
            {
            	// 取左边界为短板
                smaller = height[left];
                // 加上所以比短板小的面积
                while(left < right && height[left] <= smaller) 
                {
                    area += smaller - height[left];
                    left++;
                }
            } 
            else 
            {
            	// 取右边界为短板
                smaller = height[right];
                // 加上所以比短板小的面积
                while(left < right && height[right] <= smaller) 
                {
                    area += smaller - height[right];
                    right--;
                }
            }
        }
        return area;
    }
}