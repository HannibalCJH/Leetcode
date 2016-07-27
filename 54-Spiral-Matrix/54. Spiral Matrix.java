public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        if(matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<Integer>();
            
        int m = matrix.length, n = matrix[0].length;
        List<Integer> result = new ArrayList<Integer>();
        // 计算层数
        int layer = (Math.min(m, n) + 1) / 2;
        for(int i = 0; i < layer; i++)
        {
            // 第一行就是最后一行，则直接输出这行
            if(i == m - 1 - i)
                for(int j = i; j < n - 1 - i; j++)
                    result.add(matrix[i][j]);
            // 第一列就是最后一列，则直接输出这列
            else if(i == n - 1 - i)
                for(int j = i; j < m - 1 - i; j++)
                    result.add(matrix[j][i]);
            else
            {
                // 第一行
                for(int j = i; j < n - 1 - i; j++)
                    result.add(matrix[i][j]);
                // 最后一列
                for(int j = i; j < m - 1 - i; j++)
                    result.add(matrix[j][n-1-i]);
                // 最后一行
                for(int j = n - 1 - i; j > i; j--)
                    result.add(matrix[m-1-i][j]);
                // 第一列
                for(int j = m - 1 - i; j > i; j--)
                    result.add(matrix[j][i]);
            }
        }
        return result;
    }
}