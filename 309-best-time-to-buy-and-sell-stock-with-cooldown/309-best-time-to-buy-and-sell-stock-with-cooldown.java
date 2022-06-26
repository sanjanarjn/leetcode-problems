class Solution {



    public int maxProfit(int[] prices) {

        int n = prices.length;
        
        int[] buyingProfits = new int[n];
        int[] sellingProfits = new int[n];
        int[] coolDownProfits = new int[n];
        
        buyingProfits[0] = -prices[0];
        for(int i = 1; i < n; i++) {
            int sellingProfit_2DaysBack = i > 1 ? sellingProfits[i - 2] : 0;
            buyingProfits[i] = Math.max(buyingProfits[i - 1], coolDownProfits[i - 1] - prices[i]);
            sellingProfits[i] = Math.max(sellingProfits[i - 1], buyingProfits[i - 1] + prices[i]);
            coolDownProfits[i] = Math.max(coolDownProfits[i - 1], sellingProfits[i - 1]);
        }
        return sellingProfits[n - 1];
    }

    
}