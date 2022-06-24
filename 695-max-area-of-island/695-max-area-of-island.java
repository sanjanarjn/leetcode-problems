class Solution {
    
    int m;
    int n;
    
    int[][] grid;
    boolean[][] visited;
    
    public int maxAreaOfIsland(int[][] grid) {
        
        this.m = grid.length;
        this.n = grid[0].length;
        
        this.grid = grid;
        this.visited = new boolean[m][n];
        
        int maxArea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j));
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int i, int j) {
        
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) 
            return 0;
        
        visited[i][j] = true;
        return 1 + dfs(i + 1,  j) + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i, j - 1);
    }
}