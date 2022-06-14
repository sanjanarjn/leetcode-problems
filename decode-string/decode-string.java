class Solution {
    
    public String decodeString(String s) {
        
        int n = s.length();
        StringBuilder token = new StringBuilder();
        Stack<String> stack = new Stack<>();
        
        char prevChar = '\0';
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            boolean isPrevCharDigit = Character.isDigit(prevChar);
            boolean isPrevCharAlpha = Character.isAlphabetic(prevChar);
            
            if(Character.isDigit(c)) {
                if(!isPrevCharDigit) {
                    if(token.length() > 0) {
                        stack.push(token.toString());
                        token.setLength(0);
                    }
                }
                token.append(c);
            }
            else if(Character.isAlphabetic(c)) {
                
                token.append(c);
            }
            else if(c == '[') {
                stack.push(token.toString());
                token.setLength(0);
                stack.push("[");
            }
            else if(c == ']') {
                stack.push(token.toString());
                token.setLength(0);
                List<String> tokens = new ArrayList<>();
                while(!stack.isEmpty() && stack.peek() != "[") {
                    tokens.add(stack.pop());
                }
                stack.pop();
                tokens.add(stack.pop());
                stack.push(evaluate(tokens));
            }
            prevChar = c;
        }
        if(token.length() > 0) {
            stack.push(token.toString());
        }
        StringBuilder output = new StringBuilder();
        while(!stack.isEmpty()) {
            output.insert(0, stack.pop());
        }
        return output.toString();
    }
    
    private String evaluate(List<String> tokens) {
        StringBuilder token = new StringBuilder();
        for(int i = tokens.size() - 2; i >= 0 ; i--) {
            token.append(tokens.get(i));
        }
        int count = Integer.parseInt(tokens.get(tokens.size() - 1));
        StringBuilder eval = new StringBuilder();
        for(int i = 0; i < count; i++) {
            eval.append(token.toString());
        }
        return eval.toString();
    }
}