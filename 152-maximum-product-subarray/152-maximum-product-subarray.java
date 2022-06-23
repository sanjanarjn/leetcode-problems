class Solution {
    
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        
        if(n == 1)
            return nums[0];
        
        int max = 1;
        int min = 1;
        
        int maxProduct = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            
            if(curr == 0) {
                max = 1;
                min = 1;
                maxProduct = Math.max(maxProduct, curr);
            }
            else {
                int newMax = Math.max(curr, Math.max(curr * max, curr * min));
                min = Math.min(curr, Math.min(curr * max, curr * min));
                
                max = newMax;
                maxProduct = Math.max(maxProduct, max);
            }
        }
        return maxProduct;
        
    }
}