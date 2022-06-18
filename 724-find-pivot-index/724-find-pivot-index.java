class Solution {
    public int pivotIndex(int[] nums) {
        
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        int rightSum = totalSum;
        
        int pivotI = -1;
        for(int i = 0; i < nums.length; i++) {
            
            int elem = nums[i];
            if(rightSum - elem == leftSum) {
                pivotI = i;
                break;
            }
            leftSum += elem;
            rightSum -= elem;
        }
        return pivotI;
    }
}