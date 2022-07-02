class Solution {
    
    public boolean backspaceCompare(String s, String t) {
       
        int m = s.length() - 1;
        int n = t.length() - 1;
       
        Stack<Character> sStack = getStack(s);
        Stack<Character> tStack = getStack(t);
        
        if(sStack.size() != tStack.size())
            return false;
        
        while(!sStack.isEmpty()) {
            if(sStack.pop() != tStack.pop())
                return false;
        }
        return true;
    }
    
    private Stack<Character> getStack(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i) == '#') {
                if(!stack.isEmpty()) 
                    stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        return stack;
    }
}
//ac
//abdb###c