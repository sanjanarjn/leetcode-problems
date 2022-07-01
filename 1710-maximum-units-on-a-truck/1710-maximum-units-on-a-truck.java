class Solution {
    
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> -Integer.compare(a[1], b[1]));
        
        int totalUnits = 0;
        int size = 0;
        for(int[] boxType : boxTypes) {
            int boxCount = boxType[0];
            int units = boxType[1];
            
            int count = 0;
            while(size < truckSize && count < boxCount) {
                totalUnits += units;
                size++;
                count++;
            }
        }
        return totalUnits;
    }
}