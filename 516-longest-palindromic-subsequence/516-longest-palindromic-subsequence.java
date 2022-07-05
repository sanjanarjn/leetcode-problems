class Solution {
    
    int[][] dp;
    
    public int longestPalindromeSubseq(String s) {
        
        String reversedS = new StringBuilder(s).reverse().toString();
        return getLCS(s, reversedS);
    }
    
    private int getLCS(String a, String b) {
        
        int n = a.length();
        
        dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
       return getLCS(0, 0, a, b);
    }
    
    private int getLCS(int i, int j, String a, String b) {
        
        int n = a.length();
        if(i == n || j == n)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(a.charAt(i) == b.charAt(j)) {
            dp[i][j] = 1 + getLCS(i + 1, j + 1, a, b);
        }
        else {
            dp[i][j] = Math.max(getLCS(i, j + 1, a, b), getLCS(i + 1, j, a, b));
        }
        return dp[i][j];
    }
}