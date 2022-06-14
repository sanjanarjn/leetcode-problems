class Solution {
    
    int[][] dp;
    
    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();
        dp = new int[m][n];
            
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return minD(word1, word2, 0, 0);
    }
    
    private int minD(String word1, String word2, int i, int j) {
        
        int m = word1.length();
        int n = word2.length();
        
        if(word1.equals(word2)) {
            return 0;
        }
        
        if(i == m) {
            return n - j;
        }
        
        if(j == n) {
            return m - i;
        }

        if(dp[i][j] != -1)
            return dp[i][j];
        
        int minD = 0;
        if(word1.charAt(i) == word2.charAt(j)) {
            minD = minD(word1, word2, i + 1, j + 1);
        }
        else {
            minD = 1 + Math.min(minD(word1, word2, i, j + 1), minD(word1, word2, i + 1, j));
        }
        dp[i][j] = minD;
        return minD;
    }
}