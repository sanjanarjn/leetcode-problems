class Solution {
    
    List<List<Integer>> output = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        
        int n = nums.length;
        if(n == 1) {
            List<Integer> permutation = new ArrayList<>();
            for(int num: nums) {
                permutation.add(num);
            }
            output.add(permutation);
            return output;
        }
        
        permute(0, nums);
        return output;
    }
    
    private void permute(int si, int[] nums) {
        
        if(si == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for(int num: nums) {
                permutation.add(num);
            }
            output.add(permutation);
            return;
        }
        permute(si + 1, nums);
        for(int i = si + 1; i < nums.length; i++) {
            swap(nums, si, i);
            permute(si + 1, nums);
            swap(nums, si, i);
        }
        return;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}