class Solution {
    
    int m;
    int n;
    
    int[][] grid1;
    int[][] grid2;
    
    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        this.grid1 = grid1;
        this.grid2 = grid2;
        
        this.m = this.grid1.length;
        this.n = this.grid1[0].length;
    
        int subIslandCount = 0;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                if(grid2[i][j] == 1) {
                    subIslandCount += dfs(i, j) ? 1 : 0;
                }
            }
        }
        return subIslandCount;
    }
    
    private boolean dfs(int i, int j) {
        
        if(i < 0 || i == m || j < 0 || j == n || grid2[i][j] == 0)
            return true;
        
        grid2[i][j] = 0;
        
        boolean notMatching = grid1[i][j] == 1;
        for(int[] d : dir) {
            notMatching = dfs(i + d[0], j + d[1]) && notMatching;
        }
        return notMatching;
    }
}