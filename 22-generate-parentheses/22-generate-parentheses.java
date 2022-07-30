class Solution {
   
    int[][] dp;
    
    public List<String> generateParenthesis(int n) {
        
        return getParentheses("(", n - 1, n);
    }
    
    private List<String> getParentheses(String str, int left, int right) {
        
        
        if(left == 0 && right == 0) {
            return new ArrayList<>(Arrays.asList(str));
        } 
        
        List<String> output = new ArrayList<>();
        if(left > right)
            return Collections.emptyList();
        else if(left < right) {
            output.addAll(getParentheses(str + ")", left, right - 1));
        }
        if(left > 0) {
            output.addAll(getParentheses(str + "(", left - 1, right));
        }
        return output;
    }
}