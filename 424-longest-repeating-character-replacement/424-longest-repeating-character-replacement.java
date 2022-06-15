class Solution {
     public int characterReplacement(String s, int k) {
        
        int[] num = new int[26];
        int n = s.length();
        
        int maxLength = 0;
        int left = 0, right = 0;
        
        while (right < n) {
            char currChar = s.charAt(right);
            num[currChar - 'A']++;
            
            while((right - left + 1) - max(num) > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            } 
            
            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }
        
        return maxLength;
    }
    
    private int max(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for(int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        return maxVal;
    }
}