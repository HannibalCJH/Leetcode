public class Solution {
    // 我的算法
    public String reverseString(String s) 
    {
        StringBuilder sb = new StringBuilder(s);
        
        int left = 0, right = s.length() - 1;
        while(left < right)
        {
            char ch = s.charAt(left);
            sb.setCharAt(left, s.charAt(right));
            sb.setCharAt(right, ch);
            left++;
            right--;
        }
        return sb.toString();
    }
}