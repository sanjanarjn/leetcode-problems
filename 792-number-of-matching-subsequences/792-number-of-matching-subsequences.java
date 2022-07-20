class Solution {
    
    Map<String, Boolean> subsequences = new HashMap<>();
    
    public int numMatchingSubseq(String s, String[] words) {
        
        int count = 0;
        Arrays.sort(words);
        for(int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if(subsequences.containsKey(word)) {
                count += subsequences.get(word) ? 1 : 0;
            }
            else {
                count += isSubsequence(s, word) ? 1 : 0;
            }
        }
        return count;
    }
    
    private boolean isSubsequence(String s, String word) {
        
        int i = 0;
        int j = 0;
        
        int n = s.length();
        int len = word.length();
        
        while(i < n && j < len) {
            if(s.charAt(i) == word.charAt(j)) {
                String substring = word.substring(0,  j + 1);
                subsequences.put(substring, true);
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        boolean isSubsequence = j == len;
        subsequences.put(word, isSubsequence);
        return isSubsequence;
    }
}