class Solution {
    
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {

        Arrays.sort(boxes);
    
        int i = boxes.length - 1;
        int count = 0;
        for(int room: warehouse) {
            
            while(i >= 0 && boxes[i] > room) {
                i--;
            }
            if(i == -1)
                break;
            count++;
            i--;
        }
     
        return count;
    }
}