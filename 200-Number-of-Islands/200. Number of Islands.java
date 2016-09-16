public class Solution {
    // 我的算法
    public int numIslands(char[][] grid) 
    {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == '1')
                {
                    dfs(grid, i, j);
                    count++;
                }
        return count;
    }
    
    // 深度优先搜索
    private void dfs(char[][] grid, int x, int y)
    {
        // 返回条件判断
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0')
            return;
        // 把已访问的元素设为0
        grid[x][y] = '0';
        // 朝四个方向深度优先搜索
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}