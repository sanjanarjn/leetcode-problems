class Solution {
    
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        int pSum = 0;
        
        
        Map<Integer, Integer> mods = new HashMap<>();
        mods.put(0, -1);
        for(int i = 0; i < n; i++) {
            pSum += nums[i];
            int mod = pSum % k;
            if(!mods.containsKey(mod)) {
                mods.put(mod, i);
            }
            else {
                if(i - mods.get(mod) > 1) return true;
            }
        }
        return false;
    }
}