class Solution {
    public int longestPalindrome(String s) {
        
        Map<Character, Integer> charCount = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        int length = 0;
        for(int eachCount : charCount.values()) {
            length += eachCount/2 * 2;
        }
        if(length < s.length())
            length++;
        return length;
    }
}