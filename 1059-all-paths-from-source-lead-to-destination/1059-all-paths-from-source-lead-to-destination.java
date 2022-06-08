class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
         
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            adjList.putIfAbsent(edges[i][0], new HashSet<Integer>());
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        
        if(adjList.containsKey(destination))
            return false;
        
        return doDfs(n, edges, source, destination, new HashSet<>(), adjList);
    }
    
    boolean doDfs(int n, int[][] edges, int node, int destination, Set<Integer> seenSet, Map<Integer, Set<Integer>> adjList){
        if(node == destination)
            return true;
        // We wanna traverse paths, node nodes, so we may revisit a node
        seenSet.add(node);
        if(adjList.get(node) == null)
            return false;
        for(Integer target : adjList.get(node)){
            if(seenSet.contains(target))
                return false; // loop
            if(!doDfs(n, edges, target, destination, seenSet, adjList))
                return false;
        }
        // done visiting the node for the iteration, we may return to this node
            // Currently it is out of the stack and no loop will happen
        seenSet.remove(node);
        return true;
    }
}