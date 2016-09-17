public class Solution {
    public int[] twoSum(int[] numbers, int target) 
    {
        if(numbers == null || numbers.length < 1)
            return null;
        int left = 0, right = numbers.length - 1;
        while(left < right)
        {
            int sum = numbers[left] + numbers[right];
            if(sum > target)
                right--;
            else if(sum < target)
                left++;
            else
                return new int[]{left + 1, right + 1};
        }
        return null;
    }
}