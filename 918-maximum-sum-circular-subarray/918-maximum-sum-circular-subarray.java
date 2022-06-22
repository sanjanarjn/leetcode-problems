class Solution {
    
    public int maxSubarraySumCircular(int[] nums) {
    
        boolean allNegatives = true;
        int kadanesMax = getMaxSum(nums);
        
        int maxNum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                allNegatives = false;
            }
            maxNum = Math.max(maxNum, nums[i]);
            nums[i] = -1 * nums[i];
        }
        
        if(allNegatives)
            return maxNum;
        
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        int invertedMax = getMaxSum(nums);
      
        return Math.max(kadanesMax, -(total - invertedMax));
    }
    
    private int getMaxSum(int[] nums) {
        int left = 0;
        int right = 0;
        
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while(right < nums.length) {
            sum += nums[right];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) {
                sum = 0;
                left = right;
            }
            right++;
        }
        return maxSum;
    }
}