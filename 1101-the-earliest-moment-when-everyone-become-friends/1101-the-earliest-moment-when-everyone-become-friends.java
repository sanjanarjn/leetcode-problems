class Solution {
    public int earliestAcq(int[][] logs, int n) {
       
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int earliestTime = -1;
        UnionFind unionFind = new UnionFind(n);
        for(int[] log : logs) {
            unionFind.union(log[1], log[2]);
            if(unionFind.groupCount() == 1) {
                earliestTime = log[0];
                break;
            }
        }
        return unionFind.groupCount() == 1 ? earliestTime : -1;
    }
}

class UnionFind {
    
    int[] root;
    int[] rank;
    int groups;
        
    public UnionFind(int n) {
        this.root = new int[n];
        this.rank = new int[n];
        for(int i = 0; i < n; i++) {
            this.root[i] = -1;
            this.rank[i] = 1;
        }
        this.groups = n;
    }
    
    public int find(int x) {
        if(root[x] == -1)
            return x;
        return root[x] = find(root[x]);
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY) {
            groups--;
            if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            }
            else if(rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            }
            else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    
    public int groupCount() {
        return groups;
    }
}