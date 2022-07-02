class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones) {
            heap.add(stone);
        }
        
        while(heap.size() > 1) {
            int heaviest = heap.remove();  
            int heavier = heap.remove();
            
            if(heaviest != heavier) {
                heap.add(heaviest - heavier);
            }
        }
        return heap.isEmpty() ? 0 :heap.peek();
    }
}