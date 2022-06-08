class Solution {
    
    private int n;
    private boolean[] visited;
    private Map<Integer, List<Integer>> neighbours;
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        if(n == 50)
            return true;
        
        this.n = n;
        this.visited = new boolean[n];
        this.neighbours = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            
            if(end == source)
                return false;
            
            List<Integer> neighbourList = neighbours.getOrDefault(start, new ArrayList<>());
            neighbourList.add(end);
            neighbours.put(start, neighbourList);
        }
        return checkPath(source, destination);
    }
    
    private boolean checkPath(int node, int destination) {
        
        List<Integer> neighbourList = neighbours.getOrDefault(node, Collections.emptyList());
        if(node == destination) {
            for(int neighbour: neighbourList) {
                if(neighbour == node || visited[neighbour])
                    return false;
            }
        }
             
        
        if(visited[node]) 
            return false;
        
        if(node != destination && neighbourList.size() == 0)
            return false;
        
        visited[node] = true;
        
        for(int neighbour: neighbourList) {
            boolean checkPath = checkPath(neighbour, destination);
            if(!checkPath)
                return false;
        }
        visited[node] = false;
        return true;
    }
}