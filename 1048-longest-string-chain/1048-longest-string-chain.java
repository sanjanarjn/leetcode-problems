class Solution {
    
    public int longestStrChain(String[] words) {
   
        int maxLen = 1;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        Map<String, Integer> dp = new HashMap<>();
        for(String word: words) {
            int currChainLen = 1;
            for(int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                int prevLen = dp.getOrDefault(predecessor, 0);
                currChainLen = Math.max(currChainLen, 1 + prevLen);
            }
            dp.put(word, currChainLen);
            maxLen = Math.max(maxLen, currChainLen);
        }
        return maxLen;
    }
}