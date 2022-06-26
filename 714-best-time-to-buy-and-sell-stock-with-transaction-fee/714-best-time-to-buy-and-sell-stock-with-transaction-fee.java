class Solution {
    
    public int maxProfit(int[] prices, int fee) {
        
        int n = prices.length;
        
        int[] buyingProfits = new int[n];
        int[] sellingProfits = new int[n];
        
        buyingProfits[0] = -prices[0];
        for(int i = 1; i < n; i++) {
            
            int prevBuyingProfit = buyingProfits[i - 1];
            int prevSellingProfit = sellingProfits[i - 1];
            
            buyingProfits[i] = Math.max(buyingProfits[i - 1], prevSellingProfit - prices[i]);
            sellingProfits[i] = Math.max(sellingProfits[i - 1], prevBuyingProfit + prices[i] - fee);
        }
        return sellingProfits[n - 1];
    }
}