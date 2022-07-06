class Solution {
    
    int[] dp;
    int[] nums;
    
    int n;
    int lis = 1;
    
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.dp = new int[n];
        
        Arrays.fill(dp, -1);
        
        getMaxLengthLIS(0);
        return lis;
    }
    
    private int getMaxLengthLIS(int i) {
        
        if(i == n - 1)
            return 1;
        
        if(dp[i] != -1) {
            return dp[i];
        }
        
        dp[i] = 1;
        for(int j = i + 1; j < n; j++) {
            int lis_J = getMaxLengthLIS(j);
            if(nums[i] < nums[j] && dp[i] < 1 + lis_J) {
                dp[i] = 1 + lis_J;
            } 
        }
        lis = Math.max(lis, dp[i]);
        return dp[i];
    }
}