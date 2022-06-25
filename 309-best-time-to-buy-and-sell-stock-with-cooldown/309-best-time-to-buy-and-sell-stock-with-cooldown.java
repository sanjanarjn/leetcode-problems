class Solution {

    Map<String, Integer> dp;

    int[] prices;
    int n;

    public int maxProfit(int[] prices) {

        this.n = prices.length;
        this.prices = prices;

        this.dp = new HashMap<>();

        return maxProfit(0, true);
    }

    private int maxProfit(int i, boolean buying) {

        if(i >= prices.length)
            return 0;

        String dpKey = i + "_" + buying;
        if(dp.containsKey(dpKey))
            return dp.get(dpKey);

        int coolDownProfit = maxProfit(i + 1, buying);
        if(buying) {
            int buyingProfit = maxProfit(i + 1, !buying) - prices[i];
            dp.put(dpKey, Math.max(buyingProfit, coolDownProfit));
        }

        else {
            int sellingProfit = maxProfit(i + 2, !buying) + prices[i];
            dp.put(dpKey, Math.max(sellingProfit, coolDownProfit));
        }
        return dp.get(dpKey);
    }
}