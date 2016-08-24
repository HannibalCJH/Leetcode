public class Solution {
    public int maxEnvelopes(int[][] envelopes) 
	{
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0)
            return 0;
        
        // 按信封的width从大到小排个序，方便后面的计算
        Arrays.sort(envelopes, new Comparator<int[]>() 
        {
            public int compare(int[] x, int[] y) 
            {
                return x[0] - y[0];
            }
        });
        
        // dp[i]表示第i个信封从0到i-1个能装的最多的信封数;
        int[] dp = new int[envelopes.length];
        //这里所有的一个信封都可以独立地表示包含一个信封，所以初始化值为1
        Arrays.fill(dp, 1);
        int max = 0;
        for(int i = 0; i < envelopes.length; i++) 
        {
            for(int k = i - 1; k >= 0; k--) 
            {
                //因为array.sort后，还会存在width相同的情况，所以操作之前要先判断width是不是严格小于现有的信封
                if(envelopes[k][0] < envelopes[i][0] && envelopes[k][1] < envelopes[i][1]) 
                	dp[i] = Math.max(dp[i], dp[k] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}