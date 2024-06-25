"""
Leetcode Challenge: Best Time to Buy and Sell Stock II

You are given an integer array prices where prices[i] is 
the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. 
You can only hold at most one share of the stock at any time. 
However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.

6/25/24
Mark Robuck
"""
class Solution:
    """
    Find the max profit by buying/selling an individual stock given a list of daily prices.
    Args:
        prices(List[int]): list of daily prices of a given stock
    Returns:
        int: max profit from buying/selling a single share
    """
    def maxProfit(self, prices: List[int]) -> int:
        max = 0
        #iterate through daily prices
        for i in range(1, len(prices)):
            #if today is higher than yesterday "buy/sell" (add difference to max)
            if prices[i] > prices[i-1]:
                diff = prices[i] - prices[i-1]
                max += diff
        return max
