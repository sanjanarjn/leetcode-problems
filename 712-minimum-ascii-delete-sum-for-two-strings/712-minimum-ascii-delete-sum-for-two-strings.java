class Solution {
    
    int m;
    int n;
    
    String s1;
    String s2;
    
    int[][] dp;
    
    public int minimumDeleteSum(String s1, String s2) {
        
        this.s1 = s1;
        this.s2 = s2;
        
        this.m = s1.length();
        this.n = s2.length();
        
        this.dp = new int[m][n];
        for(int[] row: dp) 
            Arrays.fill(row, -1);
        
        return getMinDeleteSum(0, 0);
    }
    
    private int getMinDeleteSum(int i, int j) {
        
        if(i == m) {
            int ascii = 0;
            while(j < n) {
                ascii += s2.charAt(j++);
            }
            return ascii;
        }
        
        if(j == n) {
            int ascii = 0;
            while(i < m) {
                ascii += s1.charAt(i++);
            }
            return ascii;
        }
         
        if(dp[i][j] != -1) 
            return dp[i][j];
        
        int ascii = 0;
        char s1Char = s1.charAt(i);
        char s2Char = s2.charAt(j);
        if(s1Char == s2Char) {
            ascii = getMinDeleteSum(i + 1, j + 1);
        }
        else {
            ascii = Math.min(s2Char + getMinDeleteSum(i, j + 1), s1Char + getMinDeleteSum(i + 1, j));
        }
        dp[i][j] = ascii;
        return ascii;
    
    }
}