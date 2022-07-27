class Solution {
   
    public int totalFruit(int[] fruits) {
    
        int n = fruits.length;
        if(n <= 2) {
            return n;
        }
        
        int left = 0;
        int right = 0;
        
        int maxFruits = 0;
        Map<Integer, Integer> fruitsInWindow = new HashMap<>();
        while(right < n) {
            
            fruitsInWindow.put(fruits[right], fruitsInWindow.getOrDefault(fruits[right], 0) + 1);
            
            while(fruitsInWindow.size() > 2) {
                
                int leftFruit = fruits[left];
                if(fruitsInWindow.containsKey(leftFruit)) {
                    int count = fruitsInWindow.get(leftFruit) - 1;
                    if(count == 0) {
                        fruitsInWindow.remove(leftFruit);
                    }
                    else {
                        fruitsInWindow.put(leftFruit, count);
                    }
                }
                left++;
            }
            maxFruits = Math.max(right - left + 1, maxFruits);
            right++;
        }
        return maxFruits;
    }
}