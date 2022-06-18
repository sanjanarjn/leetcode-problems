class Solution {
    
    int a = 97;
    
    public String reorganizeString(String s) {
        
        if(s.length() <= 0)
            return s;
        
        PriorityQueue<CharCount> maxHeap = new PriorityQueue<>((a, b) -> -Integer.compare(a.count, b.count));
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++) {
            if(count[i] > 0)
                maxHeap.add(new CharCount((char)(i + a), count[i]));
        }
    
        StringBuilder organisedS = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            CharCount charCount = maxHeap.remove();
            
            int len = organisedS.length();
            if(len > 0 && organisedS.charAt(len - 1) == charCount.c) {
                if(maxHeap.isEmpty())
                    break;
                
                CharCount nextCharCount = maxHeap.remove();
                updateStringAndMaxHeap(organisedS, maxHeap, nextCharCount);
                maxHeap.add(charCount);
            }
            else {
                updateStringAndMaxHeap(organisedS, maxHeap, charCount);
            }
        }
        String organisedString = organisedS.length() == s.length() ? organisedS.toString() : "";
        return organisedString;
    }
    
    private void updateStringAndMaxHeap(StringBuilder sb, PriorityQueue<CharCount> maxHeap, CharCount charCount) {
        sb.append(charCount.c);
        int reducedCount = charCount.count - 1;
        charCount.count = reducedCount;

        if(reducedCount > 0)
            maxHeap.add(charCount);
    }
}

class CharCount {
    
    char c;
    int count;
    
    CharCount(char c, int count) {
        this.c = c;
        this.count = count;
    }
}