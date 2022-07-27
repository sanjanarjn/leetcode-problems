/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class FlatTree {
    
    TreeNode first;
    TreeNode last;
    
    public FlatTree(TreeNode first, TreeNode last) {
        this.first = first;
        this.last = last;
    }
}

class Solution {
    
    public void flatten(TreeNode root) {
    
        FlatTree flatTree = flattenTree(root);
        root = flatTree == null ? root : flatTree.first;
    }
    
    private FlatTree flattenTree(TreeNode node) {
        
        if(node == null)
            return null;
        
        FlatTree flatLeft = flattenTree(node.left);
        FlatTree flatRight = flattenTree(node.right);
        
        node.left = null;
        
        TreeNode rightPointer = node;
        if(flatLeft != null) {
            rightPointer.right = flatLeft.first;
            rightPointer = flatLeft.last;
        }
        if(flatRight != null) {
            rightPointer.right = flatRight.first;
            rightPointer = flatRight.last;
        }
        FlatTree flatTree = new FlatTree(node, rightPointer);
        return flatTree;
    }
}