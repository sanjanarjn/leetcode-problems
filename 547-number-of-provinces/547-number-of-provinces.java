class Solution {
    

    public int findCircleNum(int[][] isConnected) {
    
        int count = 0;
        
        int n = isConnected.length;
        UnionFind dSet = new UnionFind(n);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1) {
                    dSet.union(i, j);
                }
            }
        }
        return dSet.getCount();
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