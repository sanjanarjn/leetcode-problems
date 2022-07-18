class Solution {
    public void sortColors(int[] nums) {
        
        
        int n = nums.length;
        if(n <= 1)
            return;
        
        int low = 0;
        int high = n - 1;
        
        int mid = 0;
        while(mid <= high) {
            int midElem = nums[mid];
            if(midElem == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(midElem == 1) {
                mid++;
            }
            else {
                swap(nums, mid, high);
                high--;
            }
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}