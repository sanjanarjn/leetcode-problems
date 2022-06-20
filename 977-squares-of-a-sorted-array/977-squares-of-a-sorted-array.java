class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        
        int[] squares = new int[n];
        
        int i = n - 1;
        while(left <= right) {
            int biggerNum;
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                biggerNum = Math.abs(nums[right]);
                right--;
            }
            else {
                biggerNum = Math.abs(nums[left]);
                left++;
            }
            squares[i--] = biggerNum * biggerNum;
        }
        return squares;
            
    }
}