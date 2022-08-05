class Solution {
    
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        
        List<Edge> edges = getEdges(points);
        Collections.sort(edges, (a, b) -> Integer.compare(a.cost, b.cost));
        
        int count = 0;
        int cost = 0;
        UnionFind unionFind = new UnionFind(n);
        for(Edge edge : edges) {
            if(!unionFind.isConnected(edge.start, edge.end)) {
                unionFind.union(edge.start, edge.end);
                count++;
                cost += edge.cost;
            }    
            if(count == n - 1)
                break;
        }
        return cost;
    }
    
    private List<Edge> getEdges(int[][] points) {
        
        List<Edge> edges = new ArrayList<>();
        int n = points.length;
        for(int i = 0; i < n; i++) {
            int[] start = points[i];
            for(int j = i + 1; j < n; j++) {
                int[] end = points[j];
                int dist = Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
                Edge edge = new Edge(i, j, dist);
                edges.add(edge);
            }
        }
        return edges;
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
    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
    public int groupCount() {
        return groups;
    }
}

class Edge {
    int start;
    int end;
    int cost;
    
    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}