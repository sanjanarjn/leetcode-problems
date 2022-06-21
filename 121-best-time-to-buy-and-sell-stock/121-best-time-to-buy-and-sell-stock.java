class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        if(n <= 1)
            return 0;
        
        int dp[] = new int[n];
        dp[n - 1] = 0;
        int maxProfit = 0;
        int maxVal = prices[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            if(prices[i] < maxVal) {
                dp[i] = maxVal - prices[i];
            }
            else {
                maxVal = prices[i];
            }
            maxProfit = Math.max(maxProfit, dp[i]);
        }
        
        return maxProfit;
    }
}