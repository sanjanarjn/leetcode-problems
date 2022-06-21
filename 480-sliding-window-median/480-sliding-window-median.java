class Solution {
    
    int[] nums;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((i, j) -> Integer.compare(i, j));
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> -Integer.compare(i, j));
    
    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        this.nums = nums;

        double[] medians = new double[n - k + 1];
        //int i = 0;
        if(k == 1) {
            for(int i = 0; i < n; i++) 
                medians[i] = nums[i];
            return medians;
        }
            
        int count = 0;
        while(count < k) {
            updateHeaps(nums[count++]);
        }
        medians[0] = getMedian();
        
        for(int i = 1; i <= n - k; i++) {
            removeElement(nums[i - 1]);
            updateHeaps(nums[i + k - 1]);
            medians[i] = getMedian();
        }
        return medians;
    }
    
    private void removeElement(int elem) {
        if(elem >= minHeap.peek()) {
            minHeap.remove(elem);
        }
        else if(elem <= maxHeap.peek()) {
            maxHeap.remove(elem);
        }
        balance();
    }
    
    private double getMedian() {
        if(minHeap.size() > maxHeap.size()) return minHeap.peek();
        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        
        return (((double) minHeap.peek())+((double) maxHeap.peek()))/2;
    }
    
    private void updateHeaps(int elem) {
 
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        
        
        if(maxHeap.isEmpty() || elem <= maxHeap.peek()) {
            maxHeap.add(elem);
        }
        else {
            minHeap.add(elem);
        }
        balance();
    }
    
    private void balance() {
        if(minHeap.size() > maxHeap.size() && minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.remove());
        }  
        else if(maxHeap.size() > minHeap.size() && maxHeap.size() - minHeap.size() > 1) {
           minHeap.add(maxHeap.remove());
        }
    }
    
}

