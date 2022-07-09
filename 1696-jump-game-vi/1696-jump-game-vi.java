class Solution {
    
    public int maxResult(int[] nums, int k) {
        
        int n = nums.length;
        
        Deque<int[]> queue = new LinkedList<>();
        int score = nums[n - 1];
        queue.add(new int[]{n - 1, nums[n - 1]});
        
        for(int i = n - 2; i >= 0; i--) {
            while(!queue.isEmpty() && queue.peekFirst()[0] > i + k) {
                queue.pollFirst();
            }
            score = nums[i] + queue.peekFirst()[1];
            while(!queue.isEmpty() && queue.peekLast()[1] <= score) {
                queue.pollLast();
            }
            queue.offerLast(new int[]{i, score});
        }
        return score;
    }
}