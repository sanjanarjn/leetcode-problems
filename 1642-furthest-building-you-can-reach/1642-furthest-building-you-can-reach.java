class Solution {
    
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int n = heights.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        int furthest = 0;
        for(int i = 0; i < n - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            
            if(diff <= 0) {
                furthest = i + 1;
                continue;
            }
            
            if(ladders > 0) {
                ladders--;
                minHeap.add(diff);
                furthest = i + 1;
            }
            else {
                int lesserDiff = diff;
                if(!minHeap.isEmpty() && diff > minHeap.peek()) {
                    lesserDiff = minHeap.remove();
                    minHeap.add(diff);
                }
                if(bricks < lesserDiff) {
                    break;
                }
                bricks -= lesserDiff;
                furthest = i + 1;
            }
            
        }
        return furthest;
    }
}