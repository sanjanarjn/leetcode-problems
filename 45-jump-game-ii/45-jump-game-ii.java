class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        if(n <= 1)
            return 0;
        
        int destination = n - 1;
        int[] minJumps = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            
            int farthest = i + nums[i];
            if(farthest >= destination) {
                minJumps[i] = 1;
            }
            else {
                int minFarthest = Integer.MAX_VALUE;
                for(int j = i + 1; j <= farthest; j++) {
                   minFarthest = Math.min(minFarthest, minJumps[j]);
                }
                minJumps[i] = minFarthest < Integer.MAX_VALUE ? 1 + minFarthest : Integer.MAX_VALUE;
            }
        }
        return minJumps[0];
    }
}