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

class Detail {
    Integer min;
    Integer max;
    boolean isBst;
    
    Detail() {
        
    }
    
    Detail(Integer min, Integer max, boolean isBst) {
        this.min = min;
        this.max = max;
        this.isBst = isBst;
    }
}

class Solution {
    
    public boolean isValidBST(TreeNode root) {
        return isBST(root).isBst;
    }
    
    private Detail isBST(TreeNode node) {
        
        if(node == null)
            return null;
        
        Detail leftDetail = isBST(node.left);
        Detail rightDetail = isBST(node.right);

        int val = node.val;
        
        Detail detail = new Detail();
        detail.isBst = true;
        detail.min = val;
        detail.max = val;
        
        if(leftDetail != null) {
            detail.min = Math.min(detail.min, leftDetail.min);
            detail.max = Math.max(detail.max, leftDetail.max);
            detail.isBst = detail.isBst && leftDetail.isBst && val > leftDetail.max;
        }
        
        if(rightDetail != null) {
            detail.min = Math.min(detail.min, rightDetail.min);
            detail.max = Math.max(detail.max, rightDetail.max);
            detail.isBst = detail.isBst && rightDetail.isBst && val < rightDetail.min;
        }
        return detail;
    }
}