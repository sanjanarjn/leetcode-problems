class Solution {
    public int[] findBuildings(int[] heights) {
        
        int n = heights.length;
        
        List<Integer> output = new LinkedList<>();
        output.add(0, n - 1);
        
        int maxHeight = heights[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            
            if(heights[i] > maxHeight) {
                output.add(0, i);
            }
            maxHeight = Math.max(maxHeight, heights[i]);
        }
        int[] outputArr = new int[output.size()];
        int i = 0;
        for(int eachVal : output) {
            outputArr[i++] = eachVal;
        }
        return outputArr;
    }
}