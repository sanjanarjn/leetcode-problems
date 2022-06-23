class Solution {
    
    int[] nums;
    int negativeCount = 0;
    int firstNegativeIndex = -1;
    int lastNegativeIndex = -1; 
    
    public int getMaxLen(int[] nums) {
        
        this.nums = nums;
        
        int maxLen = 0;
        
        int n = nums.length;
        int i = 0;
        int j = 0;
        
        while(j < n) {
            
            int elem = nums[j];
            if(elem == 0) {
                maxLen = Math.max(maxLen, computeMaxLen(i, j - 1));
                resetValues();
                
                i = j + 1;
                j = j + 1;
                continue;
            }
            if(elem < 0) {
                firstNegativeIndex = firstNegativeIndex == -1 ? j : firstNegativeIndex;
                lastNegativeIndex = j;
                negativeCount++;
            }
            j++;
        }
        return Math.max(maxLen, computeMaxLen(i, j - 1));
    }
    
    private int computeMaxLen(int i, int j) {
        if(this.negativeCount % 2 == 0) {
            return j - i + 1;
        }
        else {
            return Math.max(lastNegativeIndex - i, j - firstNegativeIndex);
        }
    }
    
    private void resetValues() {
        this.negativeCount = 0;
        this.firstNegativeIndex = -1;
        this.lastNegativeIndex = -1; 
    }
}