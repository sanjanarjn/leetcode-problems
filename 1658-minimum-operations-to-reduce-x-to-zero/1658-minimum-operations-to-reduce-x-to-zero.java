class Solution {
    

    public int minOperations(int[] nums, int x) {
        
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
          sum += nums[i];
        
        if (sum < x)
          return -1;
        
        int target = sum - x;
        if(target == 0)
            return nums.length;


        int ans = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int curr = 0, count = 0;
        while(r < nums.length) {
            curr += nums[r];
            
            while(l < r && curr > target) {
                curr = curr - nums[l];
                l += 1;
            }
            
            if(curr == target) {
                count = Math.max(count, r - l + 1);
            }
            r++;
        }

        if(count == 0)
            return -1;
        else
            return nums.length - count;
    }
}