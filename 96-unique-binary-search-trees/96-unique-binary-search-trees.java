class Solution {
    
    int[][] dp;
    
    public int numTrees(int n) {
        
        this.dp = new int[n + 1][n + 1];
        for(int i = 0; i <=n; i++) {
             Arrays.fill(dp[i], -1);
        }
      
        return numTrees(1, n);
    }
    
    private int numTrees(int start, int end) {
        
        if(start >= end)
            return 1;
        
        if(dp[start][end] != -1)
            return dp[start][end];
        
        int ans = 0;
        for(int i = start; i <= end; i++) {
            ans += numTrees(start, i - 1) * numTrees(i + 1, end);
        }
        dp[start][end] = ans;
        return dp[start][end];
    }
}