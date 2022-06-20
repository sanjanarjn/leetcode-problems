class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        if(n <= 1)
            return;
        
        k = k % n;
        reverse(nums, 0, n - 1 - k);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
    
    private void reverse(int[] nums, int si, int ei) {
        while(si < ei) {
            swap(nums, si++, ei--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}