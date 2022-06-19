class Solution {
    
    public void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }
    
    public void reverse(char[] s, int si, int ei) {
        
        if(si > ei) 
            return;
        
        swap(s, si, ei);
        reverse(s, si+1, ei-1);
    }
    
    public void swap(char[] s, int si, int ei) {
        char temp = s[si];
        s[si] = s[ei];
        s[ei] = temp;
    }
}