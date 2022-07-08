class Solution {
    
    public int integerBreak(int n) {
        
       if(n==2)
            return 1;
        if(n==3)
            return 2;
        int x;
        x = n/3;
        
        if(n % 3 == 0)
            return (int) Math.pow(3, x);
        
        if(n % 3 == 1)
            return (int) Math.pow(3, x - 1) * 4;
        
        return (int) Math.pow(3 , x) * 2;
    }
}

// 5 - 6
// 6 - 9
// 7 - 12, 
// 8 - 18, 
// 9 - 27, 
// 10 - 36
// 11 - 54
// 12 - 81
// 13 - 108
// 14 - 162