class Solution {
    
    int n;
    int[][] dp;
    Set<String> dict;
        
    public boolean wordBreak(String s, List<String> wordDict) {
        
        n = s.length();
        dp = new int[n + 1][n + 1];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        
        dict = new HashSet<>(wordDict);
        
        return wordBreak(s, 0, 0);
    }
    
    private boolean wordBreak(String s, int i, int j) {
        if (i == n)
            return true;

        if(j == n)
            return false;

        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        boolean possible = false;
        String word = s.substring(i, j + 1);

        if (dict.contains(word))
            possible = wordBreak(s, j + 1, j + 1);

        if (!possible)
            possible = wordBreak(s, i, j + 1);

        dp[i][j] = possible ? 1 : 0;
        return dp[i][j] == 1;
    }
}