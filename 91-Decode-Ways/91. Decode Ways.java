public class Solution {
    public int numDecodings(String s) 
    {
        // 字符串为空或者首字符是0都无法解码
        if(s.length() == 0 || s.charAt(0) == '0')
            return 0;
            
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; 
        dp[1] = 1;
        for(int i = 2; i < s.length() + 1; i++)
        {
            // 取前两个字符看能不能解码
            if(Integer.parseInt(s.substring(i - 2, i)) >= 10 && Integer.parseInt(s.substring(i - 2, i)) <= 26)
                dp[i] += dp[i - 2];
            // 取上一个字符看能不能解码
            if(Integer.parseInt(s.substring(i - 1, i)) > 0)
                dp[i] += dp[i - 1];
        }
        return dp[s.length()];
    }
}