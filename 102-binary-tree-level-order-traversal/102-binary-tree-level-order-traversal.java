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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null)
            return Collections.emptyList();
        
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(root)));
        
        List<List<Integer>> levelOrder = new ArrayList<>();
        while(!queue.isEmpty()) {
            
            List<TreeNode> prevLevel = queue.remove(); 
            List<TreeNode> nextLevel = new ArrayList<>();
            
            List<Integer> eachLevelOrder = new ArrayList<>();
            for(TreeNode prevNode : prevLevel) {
                eachLevelOrder.add(prevNode.val);
                
                if(prevNode.left != null)
                    nextLevel.add(prevNode.left);
                
                if(prevNode.right != null)
                    nextLevel.add(prevNode.right);
            }
            levelOrder.add(eachLevelOrder);
            if(!nextLevel.isEmpty()) {
                queue.add(nextLevel);
            }
        }
        return levelOrder;
    }
}