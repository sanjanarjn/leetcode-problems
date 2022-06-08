class Solution {
    
    boolean[] visited;
    int[][] graph;
    int n;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
     
        this.graph = graph;  
        this.n = graph.length;
        this.visited = new boolean[n];
       
        int source = 0;
        int destination = n - 1;

        return getPaths(source, destination);
    }
    
    private List<List<Integer>> getPaths(int node, int target) {
        
        if(visited[node])
            return new ArrayList<>();
        
        if(node == target) {
            List<Integer> path = new LinkedList<>();
            path.add(target);
            
            List<List<Integer>> paths = new ArrayList<>();
            paths.add(path);
            
            return paths;
        }
        
        List<List<Integer>> paths = new ArrayList<>();
        
        visited[node] = true;
        int[] neighbours = graph[node];
        
        for(int i = 0; i < neighbours.length; i++) {
            List<List<Integer>> smallPaths = getPaths(neighbours[i], target);
            for(List<Integer> eachPath : smallPaths) {
                eachPath.add(0, node);
                paths.add(eachPath);
            }
        }
        visited[node] = false;
        return paths;
    }
}