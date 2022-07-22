class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       
        int m = text1.length();
        int n = text2.length();
        
        int[][] dp = new int[m][n];
        
        dp[m-1][n-1] = text1.charAt(m-1) == text2.charAt(n-1) ? 1 : 0;
        
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                
                if(i == m-1 && j == n-1)
                    continue;
                
                int rightLcs = j < n - 1 ? dp[i][j+1] : 0;
                int downLcs = i < m - 1 ? dp[i+1][j] : 0;
                int diagLcs = i < m - 1 && j < n - 1 ? dp[i+1][j+1] : 0;
                
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + diagLcs;
                }
                else {
                    dp[i][j] = Math.max(rightLcs, downLcs);
                }
            }
        }
        return dp[0][0];
    }
}