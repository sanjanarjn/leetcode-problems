class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> suffixWords = new HashSet<>(Arrays.asList(words));
        for(String word : words) {
            for (int i = 1; i< word.length(); i++) {
                suffixWords.remove(word.substring(i));
            }
        }
        
        int encLength = 0;
        for(String word: suffixWords) {
            encLength += word.length() + 1;
        }
        return encLength;
    }
}