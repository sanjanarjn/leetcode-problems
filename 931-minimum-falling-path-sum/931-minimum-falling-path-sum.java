class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int minSum = Integer.MAX_VALUE;
        int[][] pathSum = new int[m][n];
        for(int i = 0; i < n; i++) {
            minSum = Math.min(minSum, matrix[m - 1][i]);
            pathSum[m - 1][i] = matrix[m - 1][i];
        }
        
      
        for(int i = m - 2; i >= 0; i--) {
            minSum = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                pathSum[i][j] = matrix[i][j] + getMinSum(i, j, pathSum);
                minSum = Math.min(minSum, pathSum[i][j]);
            }
        }
        return minSum;
    }
    
    private int getMinSum(int i, int j, int[][] pathSum) {
        int leftDiagSum = j > 0 ? pathSum[i + 1][j - 1] : Integer.MAX_VALUE;
        int downSum = pathSum[i + 1][j];
        int rightDiagSum = j < pathSum[i].length - 1 ? pathSum[i + 1][j + 1] : Integer.MAX_VALUE;
        return Math.min(downSum, Math.min(leftDiagSum, rightDiagSum));
    }
}