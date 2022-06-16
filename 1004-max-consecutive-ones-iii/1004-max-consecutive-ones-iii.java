class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length;
        
        int left = 0;
        int right = 0;
        
        int longestOnes = 0;
        while(right < n) {
            if(nums[right] == 0) {
                k--;
            }   
            
            while(k < 0) {
                if(nums[left] == 0) {
                    k++;
                }
                left++;
            }
            longestOnes = Math.max(longestOnes, right - left + 1);
            right++;
        }
        return longestOnes;
    }
}