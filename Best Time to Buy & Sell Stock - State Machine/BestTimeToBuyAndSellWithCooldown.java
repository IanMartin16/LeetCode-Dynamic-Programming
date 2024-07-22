class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        if(n == 1) {
            return 0;
        }
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cooldown = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;
        cooldown[0] = 0;

        for(int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i -1], cooldown[i - 1] - prices[i]);
            sell[i] = buy[i - 1] + prices[i];
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        }
        return Math.max(sell[n - 1], cooldown[n - 1]);
    }
}


//You are given an array prices where prices[i] is the price of a given stock on the ith day.

//Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

//After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
//Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).