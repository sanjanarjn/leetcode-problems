class Solution {
    

    boolean[] visited;
    
    public int findCircleNum(int[][] isConnected) {
        
        int count = 0;
        int n = isConnected.length;
        this.visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(isConnected, i);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid, int i) {
        
        for(int col = 0; col < grid.length; col++) {
            if(grid[i][col] == 1 && !visited[col]) {
                visited[col] = true;
                dfs(grid, col);
            }
        }
    }
}

class UnionFind {

    private int[] root;
    private int[] rank;
        
    public UnionFind(int n) {
        this.root = new int[n];
        this.rank = new int[n];

        for(int i = 0; i < n; i++) {
            this.root[i] = i;
            this.rank[i] = 1;
        }
    }

    public int find(int x) {
        if(x == root[x])
            return x;

        int rootX = find(root[x]);
        root[x] = rootX;
        return rootX;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            }
            else if(rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            }
            else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
    
    public int getCount() {
        
        int count = 0;
        for(int i = 0; i < root.length; i++) {
            if(root[i] == i)
                count++;
        }
        return count;
    }
}