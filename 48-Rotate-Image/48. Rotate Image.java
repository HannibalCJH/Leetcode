public class Solution {
    public void rotate(int[][] matrix) 
    {
        if(matrix.length == 0 || matrix[0].length == 0)
            return;
        int n = matrix.length, layer = n / 2;
        // 层数
        for(int i = 0; i < layer; i++)
        {
            for(int j = i; j < n - 1 - i; j++)
            {
                int temp1 = matrix[i][j];
                int temp2 = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp1;
                temp1 = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = temp2;
                temp2 = matrix[n-1-j][i];
                matrix[n-1-j][i] = temp1;
                matrix[i][j] = temp2;
            }
        }
    }
}