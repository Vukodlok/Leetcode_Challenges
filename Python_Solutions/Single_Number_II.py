"""
Leetcode Challenge: Single Number II

Given an integer array nums where every element appears three times
 except for one, which appears exactly once. Find the single element
  and return it.

You must implement a solution with a linear runtime complexity
 and use only constant extra space.

 9/22/24
 Mark Robuck
 """

class Solution:
    """
    Find the only number in a list that only appears once.
    Args:
        nums(List[int]): list of integers, only one doesn't repeat
    Returns:
        int: value of the integer in nums that does not repeat
    """
    def singleNumber(self, nums: List[int]) -> int:
        ones, twos = 0, 0
        
        for num in nums:
            #ones holds XOR of all elements that have appeared once
            ones = (ones ^ num) & ~twos
            #twos holds XOR of all elements that have appeared twice
            twos = (twos ^ num) & ~ones
        
        return ones
        
