class Solution {
    public boolean verifyPreorder(int[] preorder) {
       
        if(preorder.length <= 1)
            return true;
        
        int minVal = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < preorder.length; i++) {
            
            int elem = preorder[i];
            if(elem < minVal)
                return false;
            
            while(!stack.isEmpty() && stack.peek() < elem) {
                minVal = stack.pop();
            }
            stack.push(elem);
        }
        return true;
        
    }
}