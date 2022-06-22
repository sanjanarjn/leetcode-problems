class Solution {
    
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((slot1, slot2) -> Integer.compare(slot1[0], slot2[0]));
        for(int i = 0; i < slots1.length; i++) {
            if (slots1[i][1] - slots1[i][0] >= duration)
                heap.add(slots1[i]);
        }
        
        for(int i = 0; i < slots2.length; i++) {
            if (slots2[i][1] - slots2[i][0] >= duration)
                heap.add(slots2[i]);
        }
        
        while(heap.size() > 1) {
            int[] slot1 = heap.remove();
            int[] slot2 = heap.peek();
            
            if(Math.min(slot1[1], slot2[1]) - Math.max(slot1[0], slot2[0]) >= duration) {
                return new ArrayList<>(Arrays.asList(Math.max(slot1[0], slot2[0]), Math.max(slot1[0], slot2[0]) + duration));
            }
        }
        return Collections.emptyList();
    }
}