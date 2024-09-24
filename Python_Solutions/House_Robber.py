"""
Leetcode Challenge: House Robber

You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint 
stopping you from robbing each of them is that adjacent houses have 
security systems connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each 
house, return the maximum amount of money you can rob tonight without 
alerting the police.

9/24/24
Mark Robuck
"""

class Solution:
    """
    Given a list of integers, find the max sum without using adjacent values.
    Args:
        nums(List[int]): list of integers representing money
    Returns:
        int: max sum without using adjacent values
    """
    def rob(self, nums: List[int]) -> int:
        #empty list
        if not nums:
            return 0
        #only one house
        if len(nums) == 1:
            return nums[0]
        
        # Initialize variables for dynamic programming
        #two house before current
        prev2 = 0
        #previous house
        prev1 = 0

        for num in nums:
            #use current or skip
            current = max(prev1, prev2 + num)
            prev2 = prev1 
            prev1 = current

        return prev1
        
