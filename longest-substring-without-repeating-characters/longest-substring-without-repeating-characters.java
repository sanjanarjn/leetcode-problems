class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0)
            return 0;
        
        String trimmedS = s.trim();
        if(s.length() > 0 && trimmedS.length() == 0)
            return 1;
        
        int maxLength = 0;
        int length = 0;
        
        Map<Character, Integer> indices = new HashMap<>();
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            int lastIndex = indices.getOrDefault(c, -1);
            
            if(lastIndex == -1) {
                length++;
            }
            else {
                left = Math.max(left, lastIndex);
                length = i - left;
            }
            if(length > maxLength) {
                maxLength = length;
            }
            indices.put(c, i);
        }
        return maxLength;
    }
}