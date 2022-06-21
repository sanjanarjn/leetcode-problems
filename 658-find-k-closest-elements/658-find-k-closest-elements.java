class Solution {
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int position = getPosition(arr, x);
        int left = -1, right = -1;
        
        List<Integer> closest = new LinkedList<>();
        
        int n = arr.length;
        if(position == n) {
            for(int i = n - 1; i >= n - k; i--) {
                closest.add(0, arr[i]);
            }
            return closest;
        }
        if(arr[position] == x) {
            closest.add(x);
            left = position - 1;
            right = position + 1;
        }
        else {
            left = position - 1;
            right = position;
        }
        
        
        while(left >= 0 && right < arr.length && closest.size() < k) {
            
            int leftDiff = x - arr[left];
            int rightDiff = arr[right] - x;
            
            if(leftDiff <= rightDiff) {
                closest.add(0, arr[left--]);
            }
            else {
                closest.add(closest.size(), arr[right++]);
            }
        }
        
        while(closest.size() < k && left >= 0) {
            closest.add(0, arr[left--]);
        }
        
        while(closest.size() < k && right < arr.length) {
             closest.add(closest.size(), arr[right++]);
        }
        return closest;
    }
    
    private int getPosition(int[] arr, int k) {
    
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(k == arr[mid])
                return mid;
            
            else if(k < arr[mid]) 
                high = mid - 1;
            
            else
                low = mid + 1;
        }
        return low;
    }
}