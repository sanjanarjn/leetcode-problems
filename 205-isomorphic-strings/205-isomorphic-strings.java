class Solution {
    
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        Map<Character, Character> mapping = new HashMap<>();
        Map<Character, Character> reverseMapping = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            if(mapping.containsKey(sChar) && mapping.get(sChar) != tChar) {
                 return false;
            }
            if(reverseMapping.containsKey(tChar) && reverseMapping.get(tChar) != sChar) {
                return false;
            }
            mapping.put(sChar, tChar);
            reverseMapping.put(tChar, sChar);
        }
        return true;
    }
}