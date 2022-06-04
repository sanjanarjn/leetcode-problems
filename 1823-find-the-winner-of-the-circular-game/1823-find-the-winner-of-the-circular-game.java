class Solution {
    
    public int findTheWinner(int n, int k) {
        
        return findWinner(n, k) + 1;
    }
    
    private int findWinner(int n, int k) {
        
        if(n == 0)
            return 0;
        
        int smallAns = findWinner(n - 1, k);
        return (smallAns + k) % n;
    }
    
}