class Solution {
    public int findDuplicate(int[] nums) {
        
       return place(nums, 0);
    }
    
    private int place(int[] nums, int i) {
        if(nums[i] == i)
            return i;
        
        int nxt = nums[i];
        nums[i] = i;
        return place(nums, nxt);
    }
}