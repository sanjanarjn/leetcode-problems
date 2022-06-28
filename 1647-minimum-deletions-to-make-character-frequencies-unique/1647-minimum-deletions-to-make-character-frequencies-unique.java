class Solution {
    public int minDeletions(String s) {
        
        int[] charCount = new int[26];
        for(int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int eachCount: charCount) {
            if(eachCount != 0) {
                maxHeap.add(eachCount);
            }
        }
        
        int deletions = 0;
        while(maxHeap.size() > 1) {
            int first = maxHeap.remove();
            int second = maxHeap.peek();
            
            if(first == second) {
                if(first > 1) {
                    maxHeap.add(first - 1);
                }
                deletions++;
            }
        }
        return deletions;
       
    }
}