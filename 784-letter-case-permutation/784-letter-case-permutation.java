class Solution {
    
    List<String> output = new ArrayList<>();
    
    public List<String> letterCasePermutation(String s) {
        
        int n = s.length();
        if(n == 0) 
            return new ArrayList<>();
        
     
        permute(0, s);
        return output;
    }
    
    private void permute(int si, String s) {
        if(si == s.length()) {
            output.add(s);
            return;
        }
        
        char c = s.charAt(si);
        if(Character.isAlphabetic(c)) {
            String upper = new StringBuilder(s.substring(0, si)).append(String.valueOf(c).toUpperCase()).append(s.substring(si + 1)).toString();
            String lower = new StringBuilder(s.substring(0, si)).append(String.valueOf(c).toLowerCase()).append(s.substring(si + 1)).toString();
            
            permute(si + 1, upper);
            permute(si + 1, lower);
        }
        else {
            permute(si + 1, s);
        }
        
        return;
        
    }
}