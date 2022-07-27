class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int n = intervals.length;
        if(n <= 1)
            return n;
        
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);
        
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= minHeap.peek()) {
                minHeap.remove();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }
}