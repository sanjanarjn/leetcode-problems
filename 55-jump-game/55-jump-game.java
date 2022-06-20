class Solution {
    
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        int destination = n - 1;
        
        if(n <= 1)
            return true;
        
        int currPos = n - 2;
        while(currPos >= 0) {
            if(currPos + nums[currPos] >= destination)
                destination = currPos;
            currPos -= 1;
        }
        return destination == 0;
    }
}