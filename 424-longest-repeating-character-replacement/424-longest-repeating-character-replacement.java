class Solution {
     public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int result = Integer.MIN_VALUE;
        int maxn = 0;
        int left = 0, right = 0;
        
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            
            while (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            
            result = Math.max(result, right - left + 1);
            
            right++;
        }
        
        return result;
    }
}