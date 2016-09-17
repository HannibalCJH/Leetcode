public class Solution {
    // 参考博文: https://segmentfault.com/a/1190000003698693
	public boolean wordBreak(String s, Set<String> wordDict) 
	{
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[s.length()] = true;
        // 外层循环递增长度
        for(int i=s.length()-1;i>=0;i--)
            // 内层循环寻找分割点
            for(int j=i;j<s.length();j++)
            {
                String sub = s.substring(i, j + 1);
                // i到j的子字符串是一个单词，而且从j+1到末尾是一个由单词组成的字符串
                if(wordDict.contains(sub) && dp[j + 1])
                {
                    dp[i] = true; // i也是一个可以拆分的点 
                    break;
                }
            }
        return dp[0];
    }
}