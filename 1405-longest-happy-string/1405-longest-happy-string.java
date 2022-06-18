class Solution {
    
    char[] abcChars = new char[]{'a', 'b', 'c'};
    
    public String longestDiverseString(int a, int b, int c) {
        
        int[] abc = new int[]{a, b, c};
        
        StringBuilder happyString = new StringBuilder();
        char lastChar = '\0';

        while(!areCharsExhausted(lastChar, abc)) {
            int maxIndex = getMaxIndex(lastChar, abc);
            char nextChar = abcChars[maxIndex];
            happyString.append(nextChar);
        
            int len = happyString.length();
            if(len > 1 && happyString.charAt(len - 1) == happyString.charAt(len - 2)) {
                lastChar = happyString.charAt(len - 1);
            }
            else {
                lastChar = '\0';
            }
            abc[maxIndex]--;
        }   
        return happyString.toString();
    }
    
    private boolean areCharsExhausted(char lastChar, int[] abc) {
        
        boolean charsExhausted = true;
        for(int i = 0; i < 3; i++) {
            if(lastChar == abcChars[i])
                continue;
            
            if(abc[i] > 0) {
                charsExhausted = false;
            }
        }
        return charsExhausted;
    }
    
    private int getMaxIndex(char lastChar, int[] abc) {
        
        int maxIndex = -1;
        for(int i = 0; i < 3; i++) {
            if(lastChar == abcChars[i])
                continue;
            
            if(maxIndex == -1 || abc[i] > abc[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }
}