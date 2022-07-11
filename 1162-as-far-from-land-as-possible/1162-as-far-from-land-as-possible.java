class Cell {
    int i;
    int j;
    
    Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    
    int[][] dir = new int[][]{{-1,0}, {0,-1},{1,0},{0,1}};
    
    public int maxDistance(int[][] grid) {
        
        int n = grid.length;
        
        Queue<List<Cell>> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        List<Cell> landCells = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    landCells.add(new Cell(i, j));
                    visited[i][j] = true;
                }
            }
        }
        if(landCells.isEmpty())
            return -1;
        
        queue.add(landCells);
        
        int distance = 0;
        while(!queue.isEmpty()) {
            List<Cell> cells = queue.remove();
            List<Cell> neighbourCells = new ArrayList<>();
            for(Cell eachCell : cells) {
                neighbourCells.addAll(getNeighbours(eachCell.i, eachCell.j, visited));
            }
            if(!neighbourCells.isEmpty()) {
                queue.add(neighbourCells);
                distance++;
            }
            
        }
        return distance == 0 ? -1 : distance;
    }
    
    private List<Cell> getNeighbours(int i, int j, boolean[][] visited) {
        
        int n = visited.length;
        List<Cell> neighbourCells = new ArrayList<>();
        for(int[] d: dir) {
            int newI = i + d[0];
            int newJ = j + d[1];
            if(newI < 0 || newI == n || newJ < 0 || newJ == n)
                continue;
            
            if(!visited[newI][newJ]) {
                visited[newI][newJ] = true;
                neighbourCells.add(new Cell(newI, newJ));
            }
        }
        return neighbourCells;
    }
}