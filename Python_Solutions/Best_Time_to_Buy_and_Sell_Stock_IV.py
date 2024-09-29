"""
Leetcode Challenge: Best Time to Buy and Sell Stock IV

You are given an integer array prices where prices[i] is the 
price of a given stock on the ith day, and an integer k.
Find the maximum profit you can achieve. You may complete at most 
k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously 
(i.e., you must sell the stock before you buy again).

9/29/24
Mark Robuck
"""

class Solution:
    """
    Find max profit from a specified number of trades.
    Args:
        k(int): max number of times stocks can be bought/sold
        prices(List[int]): list of prices on ith day
    Returns:
        int: max profit from prices with k trades
    """
    def maxProfit(self, k: int, prices: List[int]) -> int:
        #edge case: If no transactions or no prices
        if not prices or k == 0:
            return 0

        n = len(prices)

        #if k is larger than half of the total number of days, it's equivalent to unlimited transactions
        if k >= n // 2:
            return self.maxProfitUnlimited(prices)

        #initialize a 2D DP table with (k+1) transactions and n days
        dp = [[0] * n for _ in range(k+1)]

        #fill the DP table
        for t in range(1, k + 1):
            max_profit_before_buy = -prices[0]
            for d in range(1, n):
                dp[t][d] = max(dp[t][d - 1], prices[d] + max_profit_before_buy)
                max_profit_before_buy = max(max_profit_before_buy, dp[t - 1][d] - prices[d])

        return dp[k][n - 1]

    def maxProfitUnlimited(self, prices: List[int]) -> int:
        """
        Helper function to calculate the maximum profit with unlimited transactions.
        Args:
            prices (List[int]): List of stock prices.
        Returns:
            int: Maximum profit from unlimited transactions.
        """
        max_profit = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                max_profit += prices[i] - prices[i - 1]
        return max_profit
        
