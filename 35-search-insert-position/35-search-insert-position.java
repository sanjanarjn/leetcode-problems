class Solution {
    public int searchInsert(int[] arr, int target) {
        if(arr == null || arr.length == 0)
            return 0;
        
        int low = 0;
        int high = arr.length - 1;
        
        int position = -1;
        int m = target;
        
        if(m < arr[0])
            return 0;
        if(m > arr[arr.length-1])
            return arr.length;
        
        while(low <= high) {
            int mid = (low + high)/2;
            if(m == arr[mid]) {
                position = mid;
                break;
            }
            else if(m < arr[mid]) {
                high = mid - 1;
            }
            else {
                position = Math.max(position, mid + 1);
                low = mid + 1;
            }
        }
        return position;
    }
}