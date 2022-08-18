class Solution {
    
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        Map<Character, Integer> sCount = getCount(s);
        Map<Character, Integer> tCount = getCount(t);
        
        return sCount.equals(tCount);
        
    }
    
    private Map<Character, Integer> getCount(String s) {
        
        Map<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        return count;
    }
}