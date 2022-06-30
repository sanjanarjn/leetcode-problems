class Solution {
    
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int median = n % 2 == 0 ? (nums[n/2] + nums[n/2 - 1])/2 : nums[n/2];
        //System.out.println(median);
        int moves = 0;
        for(int num : nums) {
            moves += Math.abs(median - num);
        }
        return moves;
    }
}