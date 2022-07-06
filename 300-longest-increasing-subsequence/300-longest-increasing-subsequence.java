class Solution {
    
    
    public int lengthOfLIS(int[] nums) {
            
        int n = nums.length;
        int[] dp = new int[n];
        
        int lisLen = 1;
        dp[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if(nums[i] < nums[j] && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                }     
            }
            lisLen = Math.max(lisLen, dp[i]);
        }
        return lisLen;
    }
}