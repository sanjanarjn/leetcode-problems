class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(index.containsKey(target - num))
                return new int[]{index.get(target - num), i};
            
            index.put(num, i);
        }
        return null;
    }
}