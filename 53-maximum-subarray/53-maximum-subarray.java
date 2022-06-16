class Solution {
    
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        
        int left = 0;
        int right = 0;
        
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        while(right < n) {
            
            if(sum < 0) {
                sum = 0;
                left = right;
            }
            sum += nums[right];
            maxSum = Math.max(maxSum, sum);
            right++;
        }
        return maxSum;
    }
}