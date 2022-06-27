import java.util.Queue;
import java.util.LinkedList;

class Cell {
    int i;
    int j;
    
    Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    
    public int[][] updateMatrix(int[][] mat) {
        
        if(mat == null || mat.length == 0)
            return mat;
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        boolean visited[][] = new boolean[rows][cols];
        Queue<Cell> queue = new LinkedList<>();
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new Cell(i, j));
                    visited[i][j] = true;
                }
            }
        }
        
        while(!queue.isEmpty()) {
            Cell cell = queue.remove();
            
            int value = mat[cell.i][cell.j];
            List<Cell> neighbours = getNeighbours(mat, visited, cell.i, cell.j);
            for(Cell neighbour: neighbours) {
                mat[neighbour.i][neighbour.j] = value + 1;
                queue.add(neighbour);
            }
        }
        return mat;
    }
    
    private List<Cell> getNeighbours(int[][] mat, boolean[][] visited, int i, int j) {
        
        int rowLen = mat.length;
        int colLen = mat[0].length;
        
        List<Cell> neighbours = new ArrayList<>();
        if(i < rowLen - 1 && !visited[i+1][j]) {
            neighbours.add(new Cell(i+1, j));
            visited[i+1][j] = true;
        }
        if(i > 0 && !visited[i-1][j]) {
            neighbours.add(new Cell(i-1, j));
            visited[i-1][j] = true;
        }
        if(j < colLen - 1 && !visited[i][j+1]) {
            neighbours.add(new Cell(i, j+1));
            visited[i][j+1] = true;
        }
        if(j > 0 && !visited[i][j-1]) {
            neighbours.add(new Cell(i, j-1));
            visited[i][j-1] = true;
        }
        return neighbours;
    }
}