class Solution {
    
    int[][] dp;
    int[] coins;
    
    int n;
    
    public int coinChange(int[] coins, int amount) {
        
        this.coins = coins;
        
        this.n = coins.length;
        this.dp = new int[n][amount + 1];
        
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        int minCoins = coinChange(0, amount);
        return minCoins >= Integer.MAX_VALUE - 1 ? -1 : minCoins;
    }
    
    private int coinChange(int i, int amount) {
        
        if(amount == 0)
            return 0;
        
        if(i == n)
            return Integer.MAX_VALUE - 1;
        
        if(dp[i][amount] != -1) 
            return dp[i][amount];
        
        int coin = coins[i];
        int coinChangeIncl = Integer.MAX_VALUE;
        if(coin <= amount) {
            coinChangeIncl = 1 + coinChange(i, amount - coin);
        }
        int coinChangeExcl = coinChange(i + 1, amount);
        dp[i][amount] = Math.min(coinChangeIncl, coinChangeExcl);
        
        return dp[i][amount];
        
    }
}
