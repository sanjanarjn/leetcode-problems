class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int i = 1;
        int j = nums.length - 1;
        
        int sum = 0;
        while(i < nums.length) {
            sum += Math.min(nums[i - 1], nums[i]);
            i += 2;   
        }
        return sum;
    }
}