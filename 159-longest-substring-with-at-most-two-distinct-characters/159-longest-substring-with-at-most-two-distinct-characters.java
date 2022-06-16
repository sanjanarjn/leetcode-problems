class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        
        int left = 0;
        int right = 0;
        
        int maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> countMap = new HashMap<>();
        while(right < n) {
            countMap.put(s.charAt(right), countMap.getOrDefault(s.charAt(right), 0) + 1);
            
            while(countMap.size() > 2) {
                char leftChar = s.charAt(left);
                
                int count = countMap.get(leftChar) - 1;
                if(count == 0) {
                    countMap.remove(leftChar);
                }
                else {
                    countMap.put(leftChar, count);
                }
                left++;
            }
            if(right - left + 1 > maxLen) {
                maxLen = right - left + 1;
               
            }
            right++;
        }
        return maxLen;
    }
}