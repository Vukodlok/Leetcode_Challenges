"""
Leetcode Challenge: Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a 
given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock 
and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. 
If you cannot achieve any profit, return 0.

5/31/24
Mark Robuck
"""
class Solution:
    """
    find the max profit from a list of ints 
    where we buy at a low index and sell high at a later index
    Args:
        prices(List[int]): list of stock prices by day
    Returns:
        int: max profit made by buying low and selling at a later high
    """
    def maxProfit(self, prices: List[int]) -> int:
        max = 0
        min = float('inf')
        #iterate through prices for every index finding the difference
        for i in prices:
            #track the min
            if i < min:
                min = i
            #find the difference
            diff = i - min
            #track the max
            if (diff > max):
                max = diff
        return max
  """
  My original solution used a nested loop, which resulted in a time exceeded error in the test cases.  With some research I modified the code as above to prevent n^2 runtime.
  """
