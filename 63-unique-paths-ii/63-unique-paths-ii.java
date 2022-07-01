class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        
        int[][] dp = new int[m][n];
        dp[m - 1][n -  1] = 1;
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j>= 0; j--) {
                
                if(i == m - 1 && j == n - 1)
                    continue;
                
                if(obstacleGrid[i][j] == 1)
                    continue;
                
                int rightPaths = j < n - 1 ? dp[i][j + 1] : 0;
                int downPaths = i < m - 1 ? dp[i + 1][j] : 0;
                dp[i][j] = rightPaths + downPaths;
            }
        }
        return dp[0][0];
    }
}