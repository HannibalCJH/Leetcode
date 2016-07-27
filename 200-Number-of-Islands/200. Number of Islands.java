public class Solution {
    public int numIslands(char[][] grid) 
    {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length, cols = grid[0].length;
        int count = 0;
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if(grid[i][j] == '1')
                {
                    dfs(i, j, grid);
                    count++;
                }
        return count;
    }
    
    private void dfs(int row, int col, char[][] grid)
    {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0')
            return;
        // 把访问过的变成0
        grid[row][col] = '0';
        
        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
}