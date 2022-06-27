class Solution {
    
    public int trap(int[] height) {
        
        Stack<Integer> stack = new Stack<>();
        
        int trappedWater = 0;
        for(int i = 0; i < height.length; i++) {
            
            int currHeight = height[i];
            while(!stack.isEmpty() && height[stack.peek()] <= currHeight) {
                int prev = stack.pop();
                
                if(stack.isEmpty()) {
                    break;
                }
                int beforePrev = stack.peek();
                int trapHeight = Math.min(height[i], height[beforePrev]) - height[prev];
                int distance = i - beforePrev - 1;
                trappedWater += distance * trapHeight;
            }
            stack.push(i);
        }
        return trappedWater;
    }
}