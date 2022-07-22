class Solution {
    
    int[] nums1;
    int[] nums2;
    
    int m;
    int n;
    
    int[][] dp;
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        this.nums1 = nums1;
        this.nums2 = nums2;
        
        this.m = nums1.length;
        this.n = nums2.length;
        
        this.dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return getLines(0, 0);
    }
    
    private int getLines(int i, int j) {
        
        if(i == m || j == n)
            return 0;
        
        int lines;
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(nums1[i] == nums2[j]) {
            lines = 1 + getLines(i + 1, j + 1);
        }
        else {
            lines = Math.max(getLines(i, j + 1), getLines(i + 1, j));
        }
        dp[i][j] = lines;
        return lines;
    }
}