class Solution {
    
    public int nthUglyNumber(int n) {

        if(n <= 3)
            return n;

        int l1 = 0, l2 = 0, l3 = 0;
        
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[l1] * 2, Math.min(dp[l2] * 3, dp[l3] * 5));
            if(dp[i] == dp[l1] * 2)
                l1++;
            
            if(dp[i] == dp[l2] * 3)
                l2++;
            
            if(dp[i] == dp[l3] * 5)
                l3++;
        }
        return dp[n - 1];
    }

    private int[] getProduct(int num) {
        return new int[]{num * 2, num * 3, num * 5};
    }
}


// 1 - 2, 3, 5
// 2 - 4, 6, 8
// 3 - 6, 9, 15
// 4 - 8, 12, 20
// 5 - 10, 15, 25
// 6 - 12, 18, 30
// 7 - 14, 21, 35
// 8 - 16, 24, 32