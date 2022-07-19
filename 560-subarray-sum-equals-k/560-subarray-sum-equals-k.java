class Solution {
    
    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        
        
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        
        int count = 0;
        
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);
        for(int pSum : prefixSum) {
            count += sumCount.getOrDefault(pSum - k, 0);
            sumCount.put(pSum, sumCount.getOrDefault(pSum, 0) + 1);
        }
        return count;
    }
}