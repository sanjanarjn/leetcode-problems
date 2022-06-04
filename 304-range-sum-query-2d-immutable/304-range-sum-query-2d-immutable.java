class NumMatrix {

    int[][] cache;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
    
        cache = new int[m][n];
        cache[0][0] = matrix[0][0];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0)
                    continue;
                
                int leftSum = j > 0 ? cache[i][j - 1] : 0;
                int topSum = i > 0 ? cache[i - 1][j] : 0;
                int diagSum = i > 0 && j > 0 ? cache[i - 1][j - 1] : 0;
                
                cache[i][j] = leftSum + topSum - diagSum + matrix[i][j];
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int leftSum = col1 > 0 ? cache[row2][col1 - 1] : 0;
        int topSum = row1 > 0 ? cache[row1 - 1][col2] : 0;
        int diagSum = row1 > 0 && col1 > 0 ? cache[row1 - 1][col1 - 1] : 0;
        
        return cache[row2][col2] - (leftSum + topSum - diagSum);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */