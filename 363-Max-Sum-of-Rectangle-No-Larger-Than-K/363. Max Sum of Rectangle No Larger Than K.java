public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) 
	{
        int[][] dp = new int[matrix.length][matrix[0].length];
        // dp数组初始化，每个元素为这一列从第0到i行的元素之和
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++)
            {
                dp[i][j] = matrix[i][j];
                if(i > 0) 
                	dp[i][j] += dp[i-1][j];
            }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++)
            for(int j = i; j < matrix.length; j++)
            {
            	// 利用TreeSet的排序特性
                TreeSet<Integer> ts = new TreeSet<Integer>();
                int sum = 0;
                for(int m = 0; m < matrix[i].length; m++) 
                {
                	// 这里每加一列就会重复加上该列从第0到i-1行的元素
                    sum += dp[j][m];
                    // 减去重复加的该列从第0到i-1行的元素
                    if(i > 0) 
                    	sum -= dp[i-1][m];
                    if(sum == k) 
                    	return sum;
                    if(sum < k) 
                    	max = Math.max(max, sum);
                    Integer other = ts.ceiling(sum - k);
                    // 把这一个矩形的元素和加入集合
                    ts.add(sum);
                    if(other == null) 
                    	continue;
                    max = Math.max(max, sum - other);
                }
            }
        
        return max;
    }
}