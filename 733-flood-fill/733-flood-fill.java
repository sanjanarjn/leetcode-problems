class Solution {

    int m;
    int n;
        
    int[][] image;
    boolean[][] visited;
    
    int oldColor;
    int newColor;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        this.m = image.length;
        this.n = image[0].length;
        
        this.image = image;
        this.visited = new boolean[m][n];
       
        this.oldColor = image[sr][sc];
        this.newColor = color;
        
        paint(sr, sc);
        
        return image;
    }
    
    private void paint(int i, int j) {
        
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || image[i][j] != oldColor) {
            return;
        }
        
        visited[i][j] = true;
        image[i][j] = newColor;
        
        paint(i + 1, j);
        paint(i, j + 1);
        paint(i - 1, j);
        paint(i, j - 1);
        
    }
}