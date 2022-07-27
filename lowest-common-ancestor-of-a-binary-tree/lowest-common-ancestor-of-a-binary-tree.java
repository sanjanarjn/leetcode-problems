/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
            return null;
        
        return lca(root, p, q);
    }
    
    private TreeNode lca(TreeNode node, TreeNode p, TreeNode q) {
        
        if(node == null)
            return null;
        
        if(node.val == p.val)
            return p;
        
        if(node.val == q.val)
            return q;
        
        TreeNode leftLca = lca(node.left, p, q);
        TreeNode rightLca = lca(node.right, p, q);
        
        if(leftLca != null && rightLca != null)
            return node;
        
        else if(leftLca == null && rightLca != null)
            return rightLca;
        
        else if(leftLca != null && rightLca == null)
            return leftLca;
        
        return null;
    }
}