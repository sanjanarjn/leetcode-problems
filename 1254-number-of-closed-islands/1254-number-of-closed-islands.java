class Solution {
    
    int m;
    int n;
    
    int[][] grid;
    
    final int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int closedIsland(int[][] grid) {
        
        this.grid = grid;
        
        this.m = grid.length;
        this.n = grid[0].length;
        
        int closedCount = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    closedCount += dfs(i, j) ? 1 : 0;
                }
            }
        }
        return closedCount;
    }
    
    private boolean dfs(int i, int j) {
        
        if(i < 0 || i >= m || j < 0 || j >= n)
            return false;
        
        if(grid[i][j] == 1)
            return true;
    
        
        grid[i][j] = 1;
        boolean closed = true;
        for(int[] direction : directions) {
            closed = dfs(i + direction[0], j + direction[1]) && closed;
        }
        return closed;
    }
}