class Solution {

    int n;
    int[] prices;
    int[] buyingProfits;
    int[] sellingProfits;
    
    public int maxProfit(int[] prices) {
        
        this.prices = prices;
        this.n = prices.length;
    
        this.buyingProfits = new int[n];
        this.sellingProfits = new int[n];
        
        Arrays.fill(this.buyingProfits, Integer.MIN_VALUE);
        Arrays.fill(this.sellingProfits, Integer.MIN_VALUE);
        
        return maxProfit(true, 0);    
    }
    
    private int maxProfit(boolean canBuy, int day) {
        
        if(day >= n)
            return 0;
        
        int profit;
        if(canBuy) {
            if(this.buyingProfits[day] != Integer.MIN_VALUE)
                return this.buyingProfits[day];
            
            profit = Math.max(maxProfit(!canBuy, day + 1) - prices[day], maxProfit(canBuy, day + 1));
            this.buyingProfits[day] = profit;
        }
        else {
            if(this.sellingProfits[day] != Integer.MIN_VALUE)
                return this.sellingProfits[day];
            profit = Math.max(maxProfit(true, day + 2) + prices[day], maxProfit(canBuy, day + 1));
            this.sellingProfits[day] = profit;
        }
        return profit;
    }
}