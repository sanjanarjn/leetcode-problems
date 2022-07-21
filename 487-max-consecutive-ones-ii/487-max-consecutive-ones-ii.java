class Solution {
    
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int left = 0;
        int right = 0;
        
        int maxOnes = 0;
        int zeroes = 0;
        
        while(right < nums.length) {
            
            if(nums[right] == 0)
                zeroes++;
            
            while(zeroes > 1) {
                if(nums[left] == 0)
                    zeroes--;
                left++;
            }
            maxOnes = Math.max(maxOnes, right - left + 1);
            right++;
        }
        return maxOnes;
    }
}