class Solution {
    
    Map<Integer, Integer> indices = new HashMap<>(); 
    
    public int maximumUniqueSubarray(int[] nums) {
        
        int n = nums.length;
        if(n == 0)
            return 0;
        
        if(n == 1)
            return nums[0];
        
        int[] prefixSums = new int[n];
        prefixSums[0] = nums[0];
        
        int left = 0;
        int right = 0;
        
        int score = 0;
        int maxScore = 0;
        
        for(; right < n; right++) {
            int elem = nums[right];            
            prefixSums[right] = right == 0 ? elem : prefixSums[right - 1] + elem;
            
            boolean isElementAlreadyFound = isElementAlreadyFound(elem, left, right);
            if(isElementAlreadyFound) {
                left = indices.get(elem) + 1;         
            }
            score = left == 0 ? prefixSums[right] : prefixSums[right] - prefixSums[left - 1];
            
            indices.put(elem, right);
            maxScore = Math.max(score, maxScore);
        }
        return maxScore;
    }
    
    private boolean isElementAlreadyFound(int elem, int left, int right) {
        int lastIndex = indices.getOrDefault(elem, -1);
        return lastIndex >= left && lastIndex < right;
    }
}