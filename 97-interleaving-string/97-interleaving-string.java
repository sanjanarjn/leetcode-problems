class Solution {
    
    int[][] dp;
    int m;
    int n;
    
    String s1;
    String s2;
    String s3;
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
        
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        
        this.m = s1.length();
        this.n = s2.length();
        
        if(m + n != s3.length())
            return false;
        
        this.dp = new int[m + 1][n + 1];
        
        for(int[] row :  dp) {
            Arrays.fill(row, -1);
        }
        return isInterleave(0, 0);
    }
    
    private boolean isInterleave(int i, int j) {
        
        if(i == m && j == n)
            return true;
        
        if(dp[i][j] != -1)
            return dp[i][j] == 1;
        
        if(i < m && s1.charAt(i) == s3.charAt(i + j) && isInterleave(i + 1, j))
            return true;
        
        if(j < n && s2.charAt(j) == s3.charAt(i + j) && isInterleave(i, j + 1))
            return true;
        
        dp[i][j] = 0;
        return dp[i][j] == 1;
    }
}