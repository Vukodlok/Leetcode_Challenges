"""
Leetcode Challenge: Maximum Subarray 

Given an integer array nums, find the subarray with the largest sum, 
and return its sum.

9/16/24
Mark Robuck
"""

class Solution:
    """
    Find the subarray in an array with largest sum. (Kadane's Algorithm)
    Args:
        nums(List[int]): starting array of integers
    Returns:
        int: largest sum of a subarray in nums
    """
    def maxSubArray(self, nums: List[int]) -> int:
        current_sum = max_sum = nums[0]
        
        # traverse the array starting from the second element
        for num in nums[1:]:
            #either extend the current subarray or start new from this element
            current_sum = max(num, current_sum + num)
            #update max_sum to keep track of the largest sum so far
            max_sum = max(max_sum, current_sum)
        
        return max_sum
        
