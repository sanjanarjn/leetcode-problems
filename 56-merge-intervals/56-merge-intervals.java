class Solution {
    
    public int[][] merge(int[][] intervals) {
        
        if(intervals == null || intervals.length <= 1)
            return intervals;
        
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        int currStart = 0;
        int currEnd = 0;
        
        List<Integer[]> output = new ArrayList<>();
        
        boolean isOverlapping = false;
        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            
            currStart = interval[0];
            currEnd = interval[1];
            
            isOverlapping = currStart <= end || currEnd <= end;
            if(isOverlapping) {
                end = Math.max(end, currEnd);
            }
            else {
                output.add(new Integer[]{start, end});
                start = currStart;
                end = currEnd;
            }
        }
        
        if(!isOverlapping) {
            output.add(new Integer[]{currStart, currEnd});
        }
        else {
            output.add(new Integer[]{start, end});
        }
        
        int[][] outputArr = new int[output.size()][];
        int i = 0;
        for(Integer[] range: output) {
            outputArr[i++] = new int[]{range[0], range[1]};
        }
        return outputArr;
    }
}