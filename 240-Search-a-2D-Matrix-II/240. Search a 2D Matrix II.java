public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
	{
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return false;
        
        int m = matrix.length, n = matrix[0].length;
        // 从矩阵的右上角开始判断，不断缩小目标所在的矩阵
        int i = 0, j = n - 1;
        while(i < m && j >= 0)
        {
        	// 如果matrix[i][j]小于目标，则不可能在这一行所以换到下一行 
        	if(matrix[i][j] < target)
        		i++;
        	// 如果matrix[i][j]等于目标，则返回真
        	else if(matrix[i][j] == target)
        		return true;
        	// 如果matrix[i][j]大于目标，则不可能在这一列所以挪到前一列
        	else
        		j--;
        }
        return false;
    }
}