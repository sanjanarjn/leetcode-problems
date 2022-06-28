class Solution {
    
        public int minDeletion(int[] nums) {

        int n = nums.length;
        int lastIndex = 0;
        int lastElement = nums[0];
        int skips = 0;

        int i = 1;
        while (i < n) {
            if (lastIndex % 2 == 0 && lastElement == nums[i]) {
                skips++;
                i++;
            } else {
                lastIndex++;
                lastElement = nums[i];
                i++;
            }
        }
        return (lastIndex + 1) % 2 == 0 ? skips : skips + 1;
    }
}