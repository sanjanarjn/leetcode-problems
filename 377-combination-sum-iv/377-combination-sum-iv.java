class Solution {
    
    int n;
    int[] nums;
    
    int[] dp;
    
    public int combinationSum4(int[] nums, int target) {
        
        this.nums = nums;
        this.n = nums.length;
        
        this.dp = new int[target + 1];
        Arrays.fill(dp, -1);
        
        return countWays(target);
    }
    
    private int countWays(int target) {
        
        if(target < 0)
            return 0;
        
        if(target == 0)
            return 1;
        
        if(dp[target] != -1)
            return dp[target];
        
        int count = 0;
        for(int num : nums) {
            count += countWays(target - num);
        }
        dp[target] = count;
        return count;
    }
}