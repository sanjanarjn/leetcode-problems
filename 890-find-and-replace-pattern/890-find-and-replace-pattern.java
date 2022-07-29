class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> matchingWords = new ArrayList<>();
        for(String word : words) {
           if(isoMorphic(word, pattern))
               matchingWords.add(word);
        }
        return matchingWords;
    }
    
    private boolean isoMorphic(String word, String pattern) {
        
        if(word.length() != pattern.length())
            return false;
        
        Map<Character, Character> mapping = new HashMap<>();
        Map<Character, Character> reverseMapping = new HashMap<>();
        for(int i = 0; i < word.length(); i++) {
            char first = pattern.charAt(i);
            char second = word.charAt(i);
            
            if(mapping.containsKey(first) && mapping.get(first) != second) {
                 return false;
            }
            if(reverseMapping.containsKey(second) && reverseMapping.get(second) != first) {
                return false;
            }
            
            reverseMapping.put(second, first);
            mapping.put(first, second);
        }
        return true;
    }
}