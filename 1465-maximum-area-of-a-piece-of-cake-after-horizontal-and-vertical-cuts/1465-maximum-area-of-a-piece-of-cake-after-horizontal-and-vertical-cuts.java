class Solution {
    
    int mod = 1000000007;
    
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        int m = horizontalCuts.length;
        int n = verticalCuts.length;
      
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[m - 1]);
        for(int i = 1; i < m; i++) {
            maxHeight = (Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1])) % mod;
        }
        
        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[n - 1]);
        for(int i = 1; i < n; i++) {
            maxWidth = (Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1])) % mod;
        }
        
        return (int) ((maxHeight * maxWidth) % mod);
        
    }
}