class Solution {
    
    int[] houses;
    int[][] cost;

    int m;
    int n;

    int target;

    Integer[][][] memo;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.m = m;
        this.n = n;

        this.cost = cost;
        this.houses = houses;

        this.target = target;

        this.memo = new Integer[m + 1][n + 1][target + 1];
        return paint(0, 0, 0);
    }

    private int paint(int houseNumber, int prevPaint, int nCount) {

        if(houseNumber == m)
            return nCount == target ? 0 : -1;

        if(nCount > target)
            return -1;

        if(memo[houseNumber][prevPaint][nCount] != null)
            return memo[houseNumber][prevPaint][nCount];
        
        int minCost;

        if(houses[houseNumber] == 0) {
            int[] costForHouse = cost[houseNumber];
            minCost = Integer.MAX_VALUE;

            for(int paint = 1; paint <= n; paint++) {
                int paintCost = costForHouse[paint - 1];
                int newNCount = prevPaint == paint ? nCount : nCount + 1;
                int nextPaintCost = paint(houseNumber + 1, paint, newNCount);
                if(nextPaintCost >= 0) {
                    int currCost = paintCost + nextPaintCost;
                    minCost = Math.min(currCost, minCost);
                }
            }
            minCost = minCost < Integer.MAX_VALUE ? minCost : -1;

        }
        else {
            int paint = houses[houseNumber];
            int newNCount = prevPaint == paint ? nCount : nCount + 1;
            minCost = paint(houseNumber + 1, paint, newNCount);
        }
        memo[houseNumber][prevPaint][nCount] = minCost;
        return minCost;
    }
}