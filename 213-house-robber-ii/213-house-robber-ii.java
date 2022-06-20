class Solution {
    public int rob(int[] nums) {
        
        if(nums == null)
            return 0;
        
        int n = nums.length;
        if(n == 0)
            return 0;
        
        if(n == 1)
            return nums[0];
        
        if(n == 2)
            return Math.max(nums[n-2], nums[n-1]);
        
        int maxExcludingLast = rob(nums, n-2);
        int maxExcludingFirst = rob(nums, n-1);
        
        return Math.max(maxExcludingFirst, maxExcludingLast);
    }
    
    private int rob(int[] nums, int ei) {
        
        int len = nums.length - 1;
        int[] amount = new int[len];
        
        amount[len - 1] = nums[ei];
        amount[len - 2] = Math.max(nums[ei-1], nums[ei]);
        
        int j = ei - 2;
        for(int i = len - 3; i >= 0; i--) {
            amount[i] = Math.max(amount[i+1], nums[j] + amount[i+2]);
            j--;
        }
        return amount[0];
    }
}