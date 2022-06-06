class Solution {
    
    public int[] sortArray(int[] nums) {
        
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int[] mergeSort(int[] nums, int si, int ei) {
        
        if(si == ei)
            return new int[]{nums[si]};
        
        int mid = (si + ei)/2;
        int[] a = mergeSort(nums, si, mid);
        int[] b = mergeSort(nums, mid + 1, ei);
        
        return merge(a, b);
    }
    
    private int[] merge(int[] a, int[] b) {
        
        int p1 = 0;
        int p2 = 0;
        
        int k = 0;
        
        int[] c = new int[a.length + b.length];
        while(p1 < a.length && p2 < b.length) {
            
            if(a[p1] <= b[p2]) {
                c[k++] = a[p1++];
            }
            else {
                c[k++] = b[p2++];
            }
        }
        
        while(p1 < a.length) {
            c[k++] = a[p1++];
        }
        
        while(p2 < b.length) {
            c[k++] = b[p2++];
        }
        
        return c;
    }
}