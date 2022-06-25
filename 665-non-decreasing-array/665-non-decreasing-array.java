class Solution {
    public boolean checkPossibility(int[] arr) {
        
        if(arr.length <= 1)
            return true;
        
        int beforePeakElement = Integer.MIN_VALUE;
        int peakElement = arr[0];
        int valleyElement = Integer.MAX_VALUE;
        
        int numValleys = 0;
        int modifications = 0;

        for(int i = 1; i < arr.length; i++) {
            
            if(numValleys > 1)
                return false;
            
            if(arr[i] < arr[i - 1]) {
                peakElement = arr[i - 1];
                beforePeakElement = i > 1 ? arr[i - 2] : beforePeakElement;
                valleyElement = arr[i];
                numValleys++;
            } 
            
            if(numValleys > 0) {
                if(modifications == 1) {
                    return false;
                }
                //Try decreasing the peak element;
                if(valleyElement >= beforePeakElement) {
                    arr[i - 1] = valleyElement;
                }
                //Try increasing the valley element;
                else {
                    arr[i] = peakElement;
                } 
                modifications++;
                numValleys--;
            }   
        }
        return true;
    }
}