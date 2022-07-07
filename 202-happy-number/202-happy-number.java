class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> seen = new HashSet<>();
        while(n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    
    private int getNext(int n) {
        
        int next = 0;
        while(n > 0) {
            int d = n % 10;
            next += d * d;
            n /= 10;
        }
        return next;
    }
}