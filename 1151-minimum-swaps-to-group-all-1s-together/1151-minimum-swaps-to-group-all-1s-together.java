class Solution {
    
    public int minSwaps(int[] data) {
        
        int n = data.length;
        
        int left = 0;
        int right = 0;
        
        int totalOnes = 0;
        for(int num : data) {
            totalOnes += num == 1 ? 1 : 0;
        }
        
        if(totalOnes == 0)
            return 0;
        
        int ones = 0;
        int zeroes = 0;
        
        int minSwaps = Integer.MAX_VALUE;
        while(right < n) {
            if(data[right] == 1) 
                ones++;
            else
                zeroes++;
            
            if(right - left + 1 == totalOnes) {
                minSwaps = Math.min(minSwaps, zeroes);
                
                if(data[left] == 1)
                    ones--;
                else
                    zeroes--;
                
                left++;
            }
            right++;
        }
        return minSwaps;
    }
}