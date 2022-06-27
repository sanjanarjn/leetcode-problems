class Solution {
    
    public int numDecodings(String s) {
        
        int n = s.length();
        
        if(n == 0 || s.startsWith("0"))
            return 0;
        
        int[] dp = new int[n];
        dp[n - 1] = isValid(s.substring(n - 1)) ? 1 : 0;
        
        if(n == 1)
            return dp[n - 1];

        for(int i = n - 2; i >= 0; i --) {
            
            if(isValid(s.substring(i, i + 1))) {
                dp[i] += dp[i + 1];
            }
            
            if(isValid(s.substring(i, i + 2))) {
                dp[i] += i < n - 2 ? dp[i + 2] : 1;
            }
        }
        return dp[0];
    }
    
    private boolean isValid(String s) {
        if(s.startsWith("0"))
            return false;
        
        int val = Integer.parseInt(s);
        if(val >= 1 && val <= 26)
            return true;
        
        return false;
    }
}