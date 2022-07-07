class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        int[] range = new int[]{-1, -1};
        
        int left = -1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(target == nums[mid]) {
                left = mid;
                high = mid - 1;
            }
            else if(target < nums[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        if(left == -1) {
            return range;
        }
        
        low = 0;
        high = nums.length - 1;
        int right = -1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(target == nums[mid]) {
                right = mid;
                low = mid + 1;
            }
            else if(target < nums[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return new int[]{left, right};
    }
}