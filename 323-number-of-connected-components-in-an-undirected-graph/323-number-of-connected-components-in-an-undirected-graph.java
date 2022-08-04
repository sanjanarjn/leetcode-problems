class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind dSet = new UnionFind(n);
        for(int[] edge : edges) {
            dSet.union(edge[0], edge[1]);
        }
        return dSet.getCount();
    }
}

class UnionFind {
    int[] root;
    int[] rank;
    
    public UnionFind(int n) {
        this.root = new int[n];
        this.rank = new int[n];
        
        for(int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x) {
        if(x == root[x]) 
            return x;
        
        return root[x] = find(root[x]);
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            
            else if(rank[rootY] > rank[rootX])
                root[rootX] = rootY;
            
            else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
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