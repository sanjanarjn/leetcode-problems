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
                    closedCount += dfs(i, j);
                }
            }
        }
        return closedCount;
    }
    
    private int dfs(int i, int j) {
        
        if(i < 0 || i >= m || j < 0 || j >= n)
            return 0;
        
        if(grid[i][j] == 1)
            return 1;
    
        
        grid[i][j] = 1;
        boolean isClosed = true;
        for(int[] direction : directions) {
            int count = dfs(i + direction[0], j + direction[1]);
            if(count == 0) {
                isClosed = false;
            }
        }
        return isClosed ? 1 : 0;
    }
}