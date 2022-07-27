class Solution {
    
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        int j = n - 2;
        
        boolean valleyFound = false;
        while(j >= 0) {
            if(nums[j] >= nums[j + 1]) {
                j--;
                continue;
            }
            else {
                reverse(nums, j + 1, n - 1);
                swapJWithNextHigherElem(nums, j, j + 1, n - 1);
                valleyFound = true;
                break;
            }
        }
        if(!valleyFound)
            reverse(nums, 0, n -1);
    }
    
    private void swapJWithNextHigherElem(int[] nums, int j, int start, int end) {
        
        int num = nums[j];
        while(start <= end) {
            int mid = (start + end)/2;
            if(num < nums[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        swap(nums, j, start);
    }
    
    private void reverse(int[] nums, int start, int end) {
        
        while(start < end) {
            swap(nums, start++, end--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
