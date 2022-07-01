class Solution {
    
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] totalSum = new int[m][n];
        totalSum[0][0] = mat[0][0];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0)
                    continue;
                
                int topSum = i > 0 ? totalSum[i - 1][j] : 0;
                int leftSum = j > 0 ? totalSum[i][j - 1] : 0;
                int diagSum = i > 0 && j > 0 ? totalSum[i - 1][j - 1] : 0;
                
                totalSum[i][j] = mat[i][j] + topSum + leftSum - diagSum;
            }
        }
        
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int r1 = Math.max(i - k, 0);
                int c1 = Math.max(j - k, 0);
                
                int r2 = Math.min(i + k, m - 1);
                int c2 = Math.min(j + k, n - 1);
                
                if(r1 == 0 && c1 == 0) 
                    ans[i][j] = totalSum[r2][c2];
                
                else if(r1 > 0 && c1 > 0)
                    ans[i][j] = totalSum[r2][c2] - totalSum[r1 - 1][c2] - totalSum[r2][c1 - 1] + totalSum[r1 - 1][c1 - 1];
                
                else if(r1 == 0 && c1 > 0)
                    ans[i][j] = totalSum[r2][c2] - totalSum[r2][c1 - 1];
                
                else if(r1 > 0 && c1 == 0)
                    ans[i][j] = totalSum[r2][c2] - totalSum[r1 - 1][c2];
            }
        }
        return ans;
    }
}