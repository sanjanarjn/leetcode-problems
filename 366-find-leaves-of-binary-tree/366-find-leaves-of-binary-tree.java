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
    
    private Map<Integer, List<Integer>> leaves = new HashMap<>();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
    
        populateLeaves(root);
        
        List<List<Integer>> leavesList = new ArrayList<>();
        for(int i = 0; i < leaves.size(); i++) {
            leavesList.add(leaves.get(i + 1));
        }
        return leavesList;
    }
    
    private int populateLeaves(TreeNode node) {
        
        if(node == null)
            return 0;
        
        int lHeight = populateLeaves(node.left);
        int rHeight = populateLeaves(node.right);
        
        int height = 1 + Math.max(lHeight, rHeight);
        
        List<Integer> nodesAtHeight = leaves.getOrDefault(height, new ArrayList<>());
        nodesAtHeight.add(node.val);
        leaves.put(height, nodesAtHeight);
        
        return height;
    }
}