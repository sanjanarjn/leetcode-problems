class Solution {

    int n;
    int[] nums;
    int[][] dp;
    
    public int lengthOfLIS(int[] nums) {
        
        this.nums = nums;
        this.n = nums.length;
        this.dp = new int[n][n + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return lis(0, -1);
    }
    
    private int lis(int i, int j) {
        
        if(i == n)
            return 0;
        
        if(dp[i][j + 1] != -1)
            return dp[i][j + 1];
        
        int lastElem = j == -1 ? Integer.MIN_VALUE : nums[j];
        int elem = nums[i];
        int lisLenIncl = Integer.MIN_VALUE;
        if(elem > lastElem) {
            lisLenIncl = 1 + lis(i + 1, i);
        }
        int lisLenExcl = lis(i + 1, j);
        dp[i][j + 1] = Math.max(lisLenIncl, lisLenExcl);
        return dp[i][j + 1];
    }
}