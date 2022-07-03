class Solution {
    
    public int wiggleMaxLength(int[] nums) {
        
        if (nums.length < 2) return nums.length;
        int maxLen = 1;
        int sign = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1] && sign != -1) {         //peak
                sign = -1;
                maxLen++;
            } else if (nums[i] > nums[i-1] && sign != 1) {   //valley
                sign = 1;
                maxLen++;
            }
        }
        return maxLen;
    }
}