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
    int minCam;
    boolean isCovered;
    boolean isRootMarked;
   
    
    public Detail() {
        
    }
    
    public Detail(int minCam, boolean isCovered, boolean isRootMarked) {
        this.minCam = minCam;
        this.isCovered = isCovered;
        this.isRootMarked = isRootMarked;
        
    }
}

class Solution {
   
 public int minCameraCover(TreeNode root) {
                
        
        Detail detail = minCam(root);
        int minCam = detail.minCam;
        
        if(!detail.isCovered)
            minCam++;
        
        return minCam;
    }
    
    private Detail minCam(TreeNode node) {
        
        if(node == null) {
            return new Detail(0, true, false);
        }
        
        Detail leftD = minCam(node.left);
        Detail rightD = minCam(node.right);
        
        Detail nodeDetail = new Detail();
        
        int minCam = leftD.minCam + rightD.minCam;
        boolean isAnyNotCovered = !leftD.isCovered || !rightD.isCovered;
        boolean isAnyRootMarked = leftD.isRootMarked || rightD.isRootMarked;
        
        if(isAnyNotCovered) {
            minCam++;
            nodeDetail.isCovered = true;
            nodeDetail.isRootMarked = true;
        }
        if(isAnyRootMarked) {
            nodeDetail.isCovered = true;
        }
        nodeDetail.minCam = minCam;
        return nodeDetail;
    }
}















