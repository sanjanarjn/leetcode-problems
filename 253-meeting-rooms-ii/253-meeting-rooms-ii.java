class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int n = intervals.length;
        if(n <= 1)
            return n;
        
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        int startPointer = 0, endPointer = 0;
        int rooms = 0;
        
        while(startPointer < n) {
            if(start[startPointer] < end[endPointer]) {
                rooms++;
            }
            else {
                endPointer++;
            }
            startPointer++;
        }
        return rooms;
    }
}