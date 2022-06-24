class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans = 0;
        int start = 0;
        
        for(int i=1;i<n;i++) {
            
            int temp = values[start] + values[i] + start - i;
            ans = Math.max(ans, temp);
            
            if((start+values[start]) < (i+values[i]))
                start = i;
        }
        
        return ans;
    }
    
    
}