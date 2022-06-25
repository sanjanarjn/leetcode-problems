class Solution {

    int[] buyingProfits;
    int[] notBuyingProfits;

    int[] prices;
    int n;

    public int maxProfit(int[] prices) {

        this.n = prices.length;
        this.prices = prices;

        this.buyingProfits = new int[n];
        this.notBuyingProfits = new int[n];

        for (int i = 0; i < n; i++) {
            buyingProfits[i] = Integer.MIN_VALUE;
            notBuyingProfits[i] = Integer.MIN_VALUE;
        }
        return maxProfit(0, true);
    }

    private int maxProfit(int i, boolean buying) {

        if (i >= prices.length) {
            return 0;
        }
        if (buying) {
            if (buyingProfits[i] > Integer.MIN_VALUE)
                return buyingProfits[i];

            int buyingProfit = maxProfit(i + 1, !buying) - prices[i];
            int coolDownProfit = maxProfit(i + 1, buying);
            buyingProfits[i] = Math.max(buyingProfit, coolDownProfit);
            return buyingProfits[i];
        }
        else {
            if (notBuyingProfits[i] > Integer.MIN_VALUE)
                return notBuyingProfits[i];

            int sellingProfit = maxProfit(i + 2, !buying) + prices[i];
            int coolDownProfit = maxProfit(i + 1, buying);
            notBuyingProfits[i] = Math.max(sellingProfit, coolDownProfit);
            return notBuyingProfits[i];
        }
    }
}