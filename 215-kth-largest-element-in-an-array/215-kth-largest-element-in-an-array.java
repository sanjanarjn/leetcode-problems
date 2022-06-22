class Solution {
    
    public int findKthLargest(int[] nums, int k) {

        int n = nums.length;
        int pivotIndex = 0;
        int si = 0;
        int ei = n - 1;
        do {
            pivotIndex = partition(nums, si, ei);
            if (pivotIndex < n - k) {
                si = pivotIndex + 1;
            } else {
                ei = pivotIndex - 1;
            }
        }
        while (pivotIndex != n - k);

        return nums[pivotIndex];
    }
    
    private int partition(int[] nums, int si, int ei) {
        
        if(si == ei)
            return si;
        
        int pivotIndex = si;
        int pivot = nums[pivotIndex];
        int i = si;
        
        for(int j = si + 1; j <= ei; j++) {
            if(nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i, pivotIndex);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}