import java.util.PriorityQueue;

class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums) {
            if(heap.size() < k) {
                heap.add(num);
            }
            else {
                if(num > heap.peek()) {
                    heap.remove();
                    heap.add(num);
                }
            }
        }
        
        return heap.peek();
    }
}