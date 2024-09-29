/*
* Leetcode Challenge: Best Time to Buy and Sell Stock IV
*
* You are given an integer array prices where prices[i] is the 
* price of a given stock on the ith day, and an integer k.
* Find the maximum profit you can achieve. You may complete at most 
* k transactions: i.e. you may buy at most k times and sell at most k times.
*
* Note: You may not engage in multiple transactions simultaneously 
* (i.e., you must sell the stock before you buy again).
*
* 9/29/24
* Mark Robuck
*/

class Solution {
    /*
    * Find the maximum profit from at most k transactions.
    * 
    * @param k, maximum number of transactions allowed
    * @param prices, list of stock prices on ith day
    * @return max profit that can be achieved with at most k transactions
    */
    public int maxProfit(int k, int[] prices) {
        // edge case: If no transactions or no prices, return 0
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        int n = prices.length;

        //if k is larger than half of the total number of days, it's equivalent to unlimited transactions
        if (k >= n / 2) {
            return maxProfitUnlimited(prices);
        }

        //initialize a 2D DP table with (k+1) transactions and n days
        int[][] dp = new int[k + 1][n];

        //fill the DP table
        for (int t = 1; t <= k; t++) {
            int maxProfitBeforeBuy = -prices[0];
            for (int d = 1; d < n; d++) {
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxProfitBeforeBuy);
                maxProfitBeforeBuy = Math.max(maxProfitBeforeBuy, dp[t - 1][d] - prices[d]);
            }
        }

        return dp[k][n - 1];
    }

    /*
    * Helper function to calculate the maximum profit with unlimited transactions.
    * 
    * @param prices, list of stock prices
    * @return max profit from unlimited transactions
    */
    private int maxProfitUnlimited(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
