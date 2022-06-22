class Solution {
    
    public String reverseWords(String s) {
        
        int start = 0;
        int end = 0;
        
        char[] sChars = s.toCharArray();
        while(end < s.length()) {
            while(end < s.length() && s.charAt(end) != ' ') {
                end++;
            }
            reverse(sChars, start, end - 1);
            start = end + 1;
            end = end + 1;
        }
        return new String(sChars);
    }
    
    private void reverse(char[] s, int si, int ei) {
        while(si <= ei) {
            char temp = s[si];
            s[si] = s[ei];
            s[ei] = temp;
            
            si++;
            ei--;
        }
    }
}