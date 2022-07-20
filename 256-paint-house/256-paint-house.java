class Solution {
    public int minCost(int[][] costs) {

        int m = costs.length;
        int n = costs[0].length;

        int minI = -1;
        int secondMinI = -1;
        
        int prevMin = 0;
        int prevSecondMin = 0;
        
        int[] dp = new int[n];
        for(int i = m - 1; i >= 0; i--) {
            
            int nextMinI = -1;
            int nextSecondMinI = -1;
            
            for(int j = 0; j < n; j++) {
                if(i == m - 1) {
                    dp[j] = costs[i][j];
                }
                else {
                    dp[j] = costs[i][j] + (j == minI ? prevSecondMin : prevMin);
                }
                
                int currCost = dp[j];
                int min = nextMinI >= 0 ? dp[nextMinI] : Integer.MAX_VALUE;
                int secondMin = nextSecondMinI >= 0 ? dp[nextSecondMinI] : Integer.MAX_VALUE;
                
                if(currCost < min) {
                    nextSecondMinI = nextMinI;
                    nextMinI = j;
                }
                else if(currCost >= min && currCost < secondMin) {
                    nextSecondMinI = j;
                }
            }
            minI = nextMinI;
            secondMinI = nextSecondMinI;
            
            prevMin = dp[nextMinI];
            prevSecondMin = dp[nextSecondMinI];
         }
        return prevMin;
    }
}