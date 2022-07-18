class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        int start = 0;
        int end = n - 1;
        
        while(start < end) {
            rotate(start, end, matrix);
            start++;
            end--;
        }
    }
    
    private void rotate(int start, int end, int[][] matrix) {
        
        int[] prev = new int[end - start + 1];
        int idx = 0;
        for(int i = start; i <= end; i++) {
            prev[idx++] = matrix[start][i];
        }
        
        idx = 0;
        for(int i = start; i <= end; i++) { 
            int nextVal = matrix[i][end];
            matrix[i][end] = prev[idx];
            prev[idx++] = nextVal;
        }
        
        idx = 1;
        for(int i = end - 1; i >= start; i--) { 
            int nextVal = matrix[end][i];
            matrix[end][i] = prev[idx];
            prev[idx++] = nextVal;
        }
        
        idx = 1;
        for(int i = end - 1; i >= start; i--) { 
            int nextVal = matrix[i][start];
            matrix[i][start] = prev[idx];
            prev[idx++] = nextVal;
        }
        
        idx = 1;
        for(int i = start + 1; i <= end; i++) { 
            matrix[start][i] = prev[idx++];
        }
        
    }
}