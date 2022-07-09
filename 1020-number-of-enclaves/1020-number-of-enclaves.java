class Solution {

    int m;
    int n;

    int[][] grid;
    boolean[][] visited;
    int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int numEnclaves(int[][] grid) {

        this.grid = grid;

        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];

        int enclaveCount = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int count = dfs(i, j);
                    enclaveCount += count > 0  ? count : 0;
                }
            }
        }
        return enclaveCount;
    }

    private int dfs(int i, int j) {

        if(i < 0 || i >= m || j < 0 || j >= n)
            return -1;

        if(visited[i][j])
            return 0;

        visited[i][j] = true;
        if(grid[i][j] == 0)
            return  0;

        boolean canWalkOff = false;
        int enclaves = 0;
        for(int[] dir : directions) {
            int count = dfs(i + dir[0], j + dir[1]);
            if(count >= 0) {
                enclaves += count;
            }
            else {
                canWalkOff = true;
            }
        }
        return canWalkOff ? -1 : 1 + enclaves;
    }
}