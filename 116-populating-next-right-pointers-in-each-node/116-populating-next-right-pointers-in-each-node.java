/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
   
    public Node connect(Node root) {
        
        if(root == null)
            return null;
        
        connect(root, false, null);
        return root;
    }
    
    private void connect(Node node, boolean isLeftChild, Node parent) {
        
        if(node == null)
            return;
        
        if(isLeftChild) {
            node.next = parent.right;
        }
        else {
            node.next = parent != null && parent.next != null ? parent.next.left : null;
        }
        connect(node.left, true, node);
        connect(node.right, false, node);
    }
}