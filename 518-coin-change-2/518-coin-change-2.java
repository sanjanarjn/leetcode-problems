class Solution {
    
    int[][] dp;
    
    int[] coins;
    int n;
    
    public int change(int amount, int[] coins) {
        
        this.coins = coins;
        this.n = coins.length;
        
        this.dp = new int[n][amount + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return change(0, amount);
    }
    
    private int change(int i, int amount) {
        
        if(i == n)
            return 0;
        
        if(amount == 0)
            return 1;
        
        if(dp[i][amount] != -1)
            return dp[i][amount];
        
        int coin = coins[i];
        int changeIncl = 0;
        if(coin <= amount) {
            changeIncl = change(i, amount - coin);
        }
        int changeExcl = change(i + 1, amount);
        dp[i][amount] = changeIncl + changeExcl;
        
        return dp[i][amount];
    }
}