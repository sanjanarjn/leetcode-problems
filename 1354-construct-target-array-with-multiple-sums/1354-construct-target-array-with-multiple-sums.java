class Solution {
    
    public boolean isPossible(int[] target) {
        
        int n = target.length;
        if(n == 1 && target[0] > 1)
            return false;
        
        int sum = 0;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : target) {
            sum += num;
            maxHeap.add(num);
        }
        
       
        while(maxHeap.peek() > 1) {
            int largest = maxHeap.remove();
            int sumWithoutLargest = sum - largest;
        
            if(sumWithoutLargest == 1)
                return true;
            
            int largestMinusRest = largest % sumWithoutLargest;    
            if(largestMinusRest >= 1 && largestMinusRest < largest) {
                maxHeap.add(largestMinusRest);
                sum = sumWithoutLargest + largestMinusRest;    
            }
            else {
                return false;
            }
        }
        return true;
    }
}