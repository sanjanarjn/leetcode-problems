class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        int maxLen = Integer.MIN_VALUE;
        for(int num : nums) {
            int start = num;
            int end = num;
            int len = 1;
            removeKey(countMap, num);
            
            while(true) {
                if(!countMap.containsKey(start - 1) && !countMap.containsKey(end + 1)) {
                    break;
                }
                if(countMap.containsKey(start - 1)) {
                    removeKey(countMap, start - 1);
                    start = start - 1;
                    len++;   
                }
                if(countMap.containsKey(end + 1)) {
                    removeKey(countMap, end + 1);
                    end = end + 1;
                    len++;
                }
            } 
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
    
    private void removeKey(Map<Integer, Integer> map, int key) {
        if(map.containsKey(key)) {
            int value = map.get(key) - 1;
            if(value == 0) {
                map.remove(key);
            }
            else map.put(key, value);
        }
    }
}