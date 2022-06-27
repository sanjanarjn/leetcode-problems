
class Solution {
    
    boolean[][] visited;
    int[][] grid;
    
    int m;
    int n;
    
    public int orangesRotting(int[][] grid) {
        
        this.grid = grid;
        
        m = grid.length;
        n = grid[0].length;
        
        visited = new boolean[m][n];
        
       
        int freshCount = 0;
        
        List<Cell> rotten = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1)
                    freshCount++;
                if(grid[i][j] == 2) {
                    rotten.add(new Cell(i, j));
                }
            }
        }
        
        if(freshCount == 0)
            return 0;
        
        if(rotten.size() == 0)
            return -1;
        
        Queue<List<Cell>> queue = new LinkedList<>();
        queue.add(rotten);
        
        int min = 0;
        while(!queue.isEmpty()) {
            rotten = queue.remove();
            List<Cell> freshNeighbours = new ArrayList<>();
            
            for(Cell eachRotten: rotten) {
                freshNeighbours.addAll(getNeighbours(eachRotten.i, eachRotten.j));
            }
            freshCount -= freshNeighbours.size();
            if(freshNeighbours.size() > 0) {
                queue.add(freshNeighbours);
                min++;
            }
        }
        return freshCount == 0 ? min : -1;
    }
    
    private List<Cell> getNeighbours(int i, int j) {
        
        List<Cell> freshNeighbours = new ArrayList<>();
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for(int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            
            if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ] && grid[newI][newJ] == 1) {
                visited[newI][newJ] = true;
                freshNeighbours.add(new Cell(newI, newJ));
            }
        }
        return freshNeighbours;
    }
        
}

class Cell {
    
    int i;
    int j;
    
    Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }
}