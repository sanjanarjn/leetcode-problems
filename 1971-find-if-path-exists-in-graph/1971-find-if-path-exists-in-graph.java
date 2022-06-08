class Solution {
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        Map<Integer, List<Integer>> adjList = getAdjList(n, edges);
        
        boolean[] visited = new boolean[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        visited[source] = true;
        
        while(!stack.isEmpty()) {
            int vertex = stack.pop();
            if(vertex == destination) 
                return true;
            
            List<Integer> neighbours = adjList.getOrDefault(vertex, new ArrayList<>());
            
            for(int neighbour :  neighbours) {
                if(!visited[neighbour]) {
                    stack.push(neighbour);
                    visited[neighbour] = true;
                }
            } 
        }
        return false;
    }
    
    private Map<Integer, List<Integer>>  getAdjList(int n, int[][] edges) {
       
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            
            List<Integer> firstNeighbours = adjList.containsKey(first) ? adjList.get(first) : new ArrayList<>();
            firstNeighbours.add(second);
            
            List<Integer> secondNeighbours = adjList.containsKey(second) ? adjList.get(second) : new ArrayList<>();
            secondNeighbours.add(first);
            
            adjList.put(first, firstNeighbours);
            adjList.put(second, secondNeighbours);
        }
        return adjList;
    }

}