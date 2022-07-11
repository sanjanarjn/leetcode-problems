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
    
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null)
            return Collections.emptyList();
        
        List<Integer> rightMost = new ArrayList<>();
        
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(root)));
        
        while(!queue.isEmpty()) {
            
            List<TreeNode> currLevel = queue.remove();
            List<TreeNode> nextLevel = new ArrayList<>();
            int levelWidth = currLevel.size();
            for(int i = 0; i < levelWidth; i++) {
                TreeNode currNode = currLevel.get(i);
                if(currNode.left != null)
                    nextLevel.add(currNode.left);
                
                if(currNode.right != null)
                    nextLevel.add(currNode.right);
                
                if(i == levelWidth - 1) 
                    rightMost.add(currNode.val);
            }
            if(nextLevel.size() > 0)
                queue.add(nextLevel);
        }
        return rightMost;
    }
}