class Solution {
    
    public String longestCommonPrefix(String[] strs) {
        
        String shortest = strs[0];
        for(String s : strs) {
            if (s.length() < shortest.length()) {
                shortest = s;
            }
        }
        
        String prefix = "";
        boolean prefixEnded = false;
        for(int i=0 ; i < shortest.length(); i++) {
            for(String s : strs) {
                if(s.charAt(i) != shortest.charAt(i)) {
                    prefixEnded = true;
                    break;
                }
            }
            if(prefixEnded) {
                break;
            }
            prefix += shortest.charAt(i);
        }
        return prefix;
    }
}