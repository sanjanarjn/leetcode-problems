class Solution {
    
    public boolean carPooling(int[][] trips, int capacity) {
        
        if(trips.length == 0)
            return true;
        
        Arrays.sort(trips, (int[] a, int[] b) -> Integer.compare(a[1], b[1]));
        
        Comparator<Integer[]> comparator = (Integer[] a, Integer[] b) -> Integer.compare(a[2], b[2]);
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(comparator);
        minHeap.add(new Integer[] {trips[0][0], trips[0][1], trips[0][2]});
        
        int currCapacity = capacity - trips[0][0];
        if(currCapacity < 0)
            return false;
        
        for(int i = 1; i < trips.length; i++) {
            
            int tripPassengers = trips[i][0];
            int tripStart = trips[i][1];
            
            while(!minHeap.isEmpty() && tripStart >= minHeap.peek()[2]) {
                currCapacity = currCapacity + minHeap.peek()[0];
                minHeap.poll();
            }
            currCapacity -= tripPassengers;
            if(currCapacity < 0)
                return false;
            
            minHeap.add(new Integer[] {trips[i][0], trips[i][1], trips[i][2]});
        }
        return true;
    }
}