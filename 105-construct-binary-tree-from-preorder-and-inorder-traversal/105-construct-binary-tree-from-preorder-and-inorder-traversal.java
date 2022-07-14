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
class Solution {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int preSi, int preEi, int[] inorder, int inSi, int inEi) {
        
        System.out.println("\nPre : "+preSi+" - "+preEi);
        System.out.println("In : "+inSi+" - "+inEi);
        if(preSi > preEi)
            return null;
        
        if(preSi == preEi) {
            return new TreeNode(preorder[preSi]);
        }
        
        int root = preorder[preSi];
        int inorderRootIndex = -1;
        for(int i = inSi; i <= inEi; i++) {
            if(root == inorder[i]) {
                inorderRootIndex = i;
                break;
            }
        }
        
        int leftTreeLength = inorderRootIndex - inSi;
        int rightTreeLength = inEi - inorderRootIndex;
        
        TreeNode rootNode = new TreeNode(root);
        TreeNode leftTree = buildTree(preorder, preSi + 1, preSi + leftTreeLength, inorder, inSi, inorderRootIndex - 1);
        TreeNode rightTree = buildTree(preorder, preSi + leftTreeLength + 1, preEi, inorder, inorderRootIndex+1, inEi);
        
        rootNode.left = leftTree;
        rootNode.right = rightTree;
        
        return rootNode;
    }
}