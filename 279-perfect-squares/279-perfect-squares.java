class Solution {
    
    public int numSquares(int n) {
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2; i <= n; i++) {
            int minSquare = (int) Math.sqrt(i);
			int minCount = Integer.MAX_VALUE;
            
            for(int j=1; j <= minSquare; j++) {
                int count = dp[i - j*j];
                if(count < minCount)
                    minCount = count;
            }
            dp[i] = 1 + minCount;
        }
        return dp[n];
    }
}