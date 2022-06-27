class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
         
        int numLen = nums.length;
        if(numLen < 3) {
            return 0;                                             
        }
        
        int i = 0;
        int j = 1;
       
        int ans = 0;
        while(j < numLen) {
            int diff = nums[j] - nums[i];
            while(j < numLen && nums[j] - nums[j - 1] == diff) {
                j++;
            }
            int len = j - i;
            if(len >= 3) {
                int n = len - 2;
                ans += (n * (n + 1))/2;
            }  
            i = j - 1;
        }
        return ans;
    }
}