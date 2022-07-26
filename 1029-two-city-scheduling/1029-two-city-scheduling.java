class Solution {
    
    int n;
    int cities;
    int[][] costs;
    int[][][] dp;
    
    public int twoCitySchedCost(int[][] costs) {
        
        this.costs = costs;
        this.n = costs.length;
        this.cities = n/2;
        
        this.dp = new int[n][cities + 1][cities + 1];
        for(int[][] row : dp) {
            for(int[] innerRow : row) {
                Arrays.fill(innerRow, -1);
            }
        }
            
        
        return getMinCost(0, 0, 0);
    }
    
    private int getMinCost(int i, int aPeople, int bPeople) {
        
        if(i == n)
            return 0;
        
        if(dp[i][aPeople][bPeople] != -1)
            return dp[i][aPeople][bPeople];
        
        int aCost = aPeople < cities ? costs[i][0] + getMinCost(i + 1, aPeople + 1, bPeople) : Integer.MAX_VALUE;
        int bCost = bPeople < cities ? costs[i][1] + getMinCost(i + 1, aPeople, bPeople + 1) : Integer.MAX_VALUE;
        
        dp[i][aPeople][bPeople] = Math.min(aCost, bCost);
        return dp[i][aPeople][bPeople];
    }
}