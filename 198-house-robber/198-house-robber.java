class Solution {
    
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n == 0)
            return 0;
        
        if(n == 1)
            return nums[0];
        
        int[] maxAmount = new int[n];
        maxAmount[n - 1] = nums[n -1];
        maxAmount[n - 2] = Math.max(nums[n - 2], nums[n - 1]);
        
        for(int i = n - 3; i >= 0; i--) {
            maxAmount[i] = Math.max(nums[i] + maxAmount[i + 2], maxAmount[i + 1]);
        }
        return maxAmount[0];
    }
}