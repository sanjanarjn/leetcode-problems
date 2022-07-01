class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 && j == n - 1)
                    continue;
                
                int topCost = i < m - 1 ? dp[i + 1][j] : Integer.MAX_VALUE;
                int leftCost = j < n - 1 ? dp[i][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = grid[i][j] + Math.min(topCost, leftCost);
            }
        }
        return dp[0][0];
    }
}