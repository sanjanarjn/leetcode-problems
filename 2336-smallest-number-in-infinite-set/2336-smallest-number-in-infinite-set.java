class SmallestInfiniteSet {

    Set<Integer> notInSet = new HashSet<>();
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    
    public SmallestInfiniteSet() {
        heap.add(1);    
    }

    public int popSmallest() {
        int smallest = heap.remove();
        int possibleNextMin = smallest + 1;
        
        boolean nextMinInSet = !notInSet.contains(possibleNextMin);
        boolean nextMinNotInHeap = heap.isEmpty() || heap.peek() > possibleNextMin;
        
        if(nextMinInSet && nextMinNotInHeap)
            heap.add(possibleNextMin);
        
        notInSet.add(smallest);
        return smallest;
    }

    public void addBack(int num) {
        if(notInSet.contains(num)) {
            heap.add(num);
            notInSet.remove(num);
        }
    }
}
/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */