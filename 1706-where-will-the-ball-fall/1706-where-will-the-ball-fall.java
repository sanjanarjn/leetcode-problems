class Solution {
    
    int m;
    int n;
    
    int[][] grid;
    int[][] dp;
    
    public int[] findBall(int[][] grid) {
        
        this.grid = grid;
       
        this.m = grid.length;
        this.n = grid[0].length;
        
        this.dp = new int[m][n];
        for(int[] dpRow : dp) {
            Arrays.fill(dpRow, -2);
        }
        
        int[] answer = new int[n];
        for(int col = 0; col < n; col++) {
            answer[col] = dfs(0, col);
        }
        return answer;
    }
    
    private int dfs(int i, int j) {
        
        if(i == m)
            return j;
        
        if(dp[i][j] != -2) {
            return dp[i][j];
        }
        
        int val = grid[i][j];
        boolean blockedWithRight = (val == 1) && ((j == n - 1) || (grid[i][j + 1] == -1));
        boolean blockedWithLeft = (val == -1) && ((j == 0) || (grid[i][j - 1] == 1));
        if(blockedWithRight || blockedWithLeft) {
            dp[i][j] = -1;
        }
        else {
            dp[i][j] = dfs(i + 1, j + val);
        }
        return dp[i][j];
    }
}