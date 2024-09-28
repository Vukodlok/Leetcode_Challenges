"""
Leetcode Challenge: Best Time to Buy and Sell Stock III

You are given an array prices where prices[i] is the price of a 
given stock on the ith day. Find the maximum profit you can achieve. 
You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously 
(i.e., you must sell the stock before you buy again).

9/28/24
Mark Robuck
"""

class Solution:
    """
    Find max profit with at most two transactions.
    Args:
        prices(List[int]): list of the price of a stock on the ith day
    Returns:
        int: max profit that can be achieved with at most two transactions
    """
    def maxProfit(self, prices: List[int]) -> int:
        #empty list
        if not prices:
            return 0
        
        #initialize variables for the two transactions
        buy1, buy2 = float('inf'), float('inf')
        profit1, profit2 = 0, 0
        
        for price in prices:
            #first transaction: minimize buy1 and maximize profit1
            buy1 = min(buy1, price)
            profit1 = max(profit1, price - buy1)
            
            #second transaction: minimize buy2 with profit1 as an offset, and maximize profit2
            buy2 = min(buy2, price - profit1)
            profit2 = max(profit2, price - buy2)
        
        return profit2
        
