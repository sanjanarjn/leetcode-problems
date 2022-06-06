class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int row = 0;
        int col = n - 1;
        
        while(row >= 0 && row < m && col >= 0 && col < n) {
            int elem = matrix[row][col];
            
            if(target == elem) 
                return true;
            else if(target < elem)
                col--;
            else if(target > elem)
                row++;
        }
        return false;
    }
}