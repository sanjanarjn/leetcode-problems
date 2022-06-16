class Solution {
    
    public List<String> findRepeatedDnaSequences(String s) {
        
        int n = s.length();
        if(n <= 10)
            return new ArrayList<>();
        
        int left = 0;
        int right = 0;
        
        Set<String> repeated = new HashSet<>();
        StringBuilder curr = new StringBuilder();
        Set<String> sequences = new HashSet<>();
        while(right < n) {
            curr.append(s.charAt(right));
            
            if(right - left + 1 == 10) {
                String sequence = curr.toString();
                if(sequences.contains(sequence)) {
                    repeated.add(sequence);
                }
                else {
                    sequences.add(sequence);
                }
                curr.deleteCharAt(0);
                left++;
            }
            right++;
        }
        return new ArrayList<>(repeated);
    }
}