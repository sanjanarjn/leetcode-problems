class Solution {
    
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
        
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        boolean subArrayFound = false;
        
        int left = 0;
        int right = 0;
        
        while(right < n) {
            sum += nums[right];
            while(sum >= target) {
                subArrayFound = true;
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return subArrayFound ? minLen : 0;
    }
}