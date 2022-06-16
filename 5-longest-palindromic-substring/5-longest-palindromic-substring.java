
class Solution {
    
    public String longestPalindrome(String s) {
         
        
        int n = s.length();
        if(n <= 1)
            return s;
        
        int dp[][] = new int[n][n];

        int maxLength = 0;
        String lps = "";
        for(int i = 0; i < n; i++) {
           dp[i][i] = 1;
           maxLength = 1;
           lps = s.substring(i, i + 1);
        }

        for(int i = 0; i < n - 1; i++) {
           if(s.charAt(i) == s.charAt(i + 1)) {
               dp[i][i+1] = 1;
               maxLength = 2;
               lps = s.substring(i, i + 2);
           }
        }

        for(int i = n - 3; i >= 0; i--) {
           for(int j = i + 2; j < n; j++) {
               boolean isPalindrome = dp[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j);
               if(isPalindrome) {
                   dp[i][j] = 1;
                   if(j - i + 1 > maxLength) {
                       maxLength = j - i + 1;
                       lps = s.substring(i, j + 1);
                   }
               }
           }
        }
        return lps;
   }
}