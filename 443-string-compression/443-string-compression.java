class Solution {
    
    public int compress(char[] chars) {
        
        int n = chars.length;
        
        int i = 1;
        int j = 1;
        char prev = chars[0];
        int count = 1;
        
        while(j < n) {
            char curr = chars[j];
            if(curr == prev) {
                count++;
            }
            else {
                if(count > 1) {
                    char[] digits = String.valueOf(count).toCharArray();;
                    for(char digit : digits) {
                        chars[i] = digit;
                        i++;
                    }
                }
                chars[i++] = curr;
                count = 1;
                prev = curr;
                
            }
            j++;
        }
        if(count > 1) {
            char[] digits = String.valueOf(count).toCharArray();;
            for(char digit : digits) {
                chars[i] = digit;
                i++;
            }
        }
        return i < n ? i : n;
    }
}