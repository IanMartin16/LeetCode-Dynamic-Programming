public class BestTimeToBuyAndSellStockWithFee {

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;
        
        int cash = 0; // Maximum profit if we do not hold a stock
        int hold = -prices[0]; // Maximum profit if we hold a stock
        
        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + prices[i] - fee); // Selling the stock
            hold = Math.max(hold, cash - prices[i]); // Buying the stock
        }
        
        return cash;
    }

    public static void main(String[] args) {
        int[] prices1 = {1, 3, 2, 8, 4, 9};
        int fee1 = 2;
        System.out.println(maxProfit(prices1, fee1)); // Expected output: 8
        
        int[] prices2 = {1, 3, 7, 5, 10, 3};
        int fee2 = 3;
        System.out.println(maxProfit(prices2, fee2)); // Expected output: 6
    }
}


//You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

//Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

//Note:

//You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
//The transaction fee is only charged once for each stock purchase and sale.