public class Solution {
    public String longestPalindrome(String s) 
    {
        if(s == null || s.length() == 0)
            return "";
        
        // 初始化结果字符为第一个字符
        String result = s.substring(0, 1);
        for(int i = 0; i < s.length() - 1; i++)
        {
            // 以一个字符为中心
            String temp = expandFromCenter(s, i, i);
            if(temp.length() > result.length())
                result = temp;
            // 以两个字符为中心
            temp = expandFromCenter(s, i, i + 1);
            if(temp.length() > result.length())
                result = temp;
        }
        return result;
    }
    
    private String expandFromCenter(String str, int left, int right)
    {
        // 从中心向左右两边比较
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right))
        {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }
}