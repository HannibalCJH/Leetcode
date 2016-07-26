public class Solution {
    public void setZeroes(int[][] matrix) 
    {
        if(matrix.length == 0 || matrix[0].length == 0)
            return;
        int m = matrix.length, n = matrix[0].length;
        boolean[] zeroRows = new boolean[m];
        boolean[] zeroCols = new boolean[n];
        
        // 标记某一行和某一列是否有0
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(matrix[i][j] == 0)
                {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
                
        for(int i = 0; i < m; i++)
            for(int j = 0;j < n; j++)
                if(zeroRows[i] || zeroCols[j])
                    matrix[i][j] = 0;
    }
}