/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
        
        if(node == null)
            return node;
        
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Node> newNodeMap = new HashMap<>();
        
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        
        Node newRoot = null;
        while(!stack.isEmpty()) {
            
            Node eachNode = stack.pop();
            int nodeVal = eachNode.val;
            if(visited.containsKey(nodeVal)) {
                continue;
            }
            
            Node newNode = newNodeMap.getOrDefault(nodeVal, new Node(nodeVal));
            if(newRoot == null)
                newRoot = newNode;
            newNodeMap.put(nodeVal, newNode);
            
            List<Node> neighbours = eachNode.neighbors;
            for(Node neighbour: neighbours) {
                stack.push(neighbour);
                
                Node newNeighbourNode = newNodeMap.getOrDefault(neighbour.val, new Node(neighbour.val));
                newNodeMap.put(neighbour.val, newNeighbourNode);
                
                newNode.neighbors.add(newNeighbourNode);
            }
            visited.put(nodeVal, true);
        }
        return newRoot;
    }
}