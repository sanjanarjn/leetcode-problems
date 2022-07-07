class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int top = 0;
        int bottom = m - 1;
        
        int right = n - 1;
        int left = 0;
        
        
        List<Integer> spiral = new ArrayList<>();
        while(spiral.size() < m * n) {
             
            //Top row
            for(int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }
            
            //Right column
            for(int i = top + 1; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            
            if(top != bottom)
                for(int i = right - 1; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
            
            if(left != right)
                for(int i = bottom - 1; i > top; i--) {
                    spiral.add(matrix[i][left]);
                }
            
            left++;
            right--;
            
            top++;
            bottom--;
        }
        
        return spiral;
    }
}