class Solution {
    
    int m;
    int n;
    
    int mod = 1000000007;
    int[][][] dp;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
       
        this.m = m;
        this.n = n;
        
        this.dp = new int[m][n][maxMove + 1];
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                 Arrays.fill(dp[i][j], -1);
            }
        }
       
        
        return getPaths(startRow, startColumn, maxMove);
    }
    
    private int getPaths(int i, int j, int moves) {
        
        if(i < 0 || i == m || j < 0 || j == n)
            return 1;
        
        if(moves == 0)
            return 0;
        
        if(dp[i][j][moves] != -1)
            return dp[i][j][moves];
        
        dp[i][j][moves] = 
            (
                (getPaths(i - 1, j, moves - 1) + getPaths(i, j - 1, moves - 1)) % mod +
                (getPaths(i + 1, j, moves - 1) + getPaths(i, j + 1, moves - 1)) % mod
            ) % mod;
            
        return dp[i][j][moves];
    }
}