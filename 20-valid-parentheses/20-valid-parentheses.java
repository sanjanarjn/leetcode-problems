import java.util.*;

class Solution {
   
    static Map<Character, Character> pairs = new HashMap<>();
    
    static {
        pairs.put(']', '[');
        pairs.put(')', '(');
        pairs.put('}', '{');
    }
    
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        
        boolean isValid = true;
        for(int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            
            if(c == ')' || c == ']' || c == '}') {
                
                if(stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                char actualPair = stack.pop();
                char expected = pairs.get(c);
                if(actualPair != expected) {
                    isValid = false;
                    break;
                }
            }
        }
        if(!stack.isEmpty()) {
            isValid = false;
        }
        return isValid;
    }
}