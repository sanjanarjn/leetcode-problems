class Solution {
    public String minRemoveToMakeValid(String s) {
        
        StringBuilder valid = new StringBuilder();
        Stack<Integer> openPStack1 = new Stack<>();
        Stack<Integer> openPStack2 = new Stack<>();
        
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                openPStack1.push(i);
                valid.append(c);
                openPStack2.push(j++);
            }
            else if(c == ')') {
                if(!openPStack1.isEmpty() && s.charAt(openPStack1.peek()) == '(') {
                    openPStack1.pop();
                    openPStack2.pop();
                    valid.append(c);
                    j++;
                }
            }
            else {
                valid.append(c);
                j++;
            } 
        }
        
        while(!openPStack1.isEmpty()) {
            openPStack1.pop();
            valid.deleteCharAt(openPStack2.pop());
        }
        return valid.toString();
    }
}