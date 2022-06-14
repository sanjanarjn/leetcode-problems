class Solution {
        public int minCost(int[][] costs) {

        int m = costs.length;
        int n = costs[0].length;

        int dp[][] = new int[m][n];

        int prevMinI = -1;
        int prevSecondMinI = -1;
        for(int house = m - 1; house >= 0; house--) {

            int currMinI = -1;
            int currSecondMinI = -1;

            for(int paint = 0; paint < n; paint++) {
                if(house == m - 1) {
                    dp[house][paint] = costs[house][paint];
                }
                else {
                    dp[house][paint] = costs[house][paint] + (paint == prevMinI ? dp[house + 1][prevSecondMinI] : dp[house + 1][prevMinI]);
                }

                int cost = dp[house][paint];
                int min = currMinI >= 0 ? dp[house][currMinI] : Integer.MAX_VALUE;
                int secondMin = currSecondMinI >= 0 ? dp[house][currSecondMinI] : Integer.MAX_VALUE;
                if(cost < min) {
                    currSecondMinI = currMinI;
                    currMinI = paint;
                }
                if(cost >= min && cost < secondMin && paint != currMinI) {
                    currSecondMinI = paint;
                }
            }
            prevMinI = currMinI;
            prevSecondMinI = currSecondMinI;
        }
        return dp[0][prevMinI];
    }
}