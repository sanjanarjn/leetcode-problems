class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();    
        int[][] dp = new int[n][n];
        
        for(int row = n -1; row >= 0; row--) {
            
            int rowMin = Integer.MAX_VALUE;
            for(int i = 0; i <= row; i++) {
                int elem = triangle.get(row).get(i);
                if(row == n - 1) {
                    dp[row][i] = elem;
                }
                else {
                    int downVal = elem + dp[row + 1][i];
                    int rightVal = elem + dp[row + 1][i + 1];
                    dp[row][i] = Math.min(downVal, rightVal);
                }
            }
        }
        return dp[0][0];
    }
}