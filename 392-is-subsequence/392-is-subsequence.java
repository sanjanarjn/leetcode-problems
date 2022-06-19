class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if(s.length() == t.length())
            return s.equals(t);

        int i = 0;
        int j = 0;
        
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        return i == s.length();
        
    }
}