class Solution {
    
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int currDay = 0;
        for (int[] course: courses) {
            
            int duration = course[0];
            int lastDay = course[1];
            
            if (currDay + duration <= lastDay) {
                maxHeap.offer(duration);
                currDay += duration;
            } else if (!maxHeap.isEmpty() && maxHeap.peek() > duration) {
                currDay += duration - maxHeap.poll();
                maxHeap.offer(duration);
            }
        }
        return maxHeap.size();
    }
}