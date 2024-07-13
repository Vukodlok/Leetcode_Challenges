"""
Leetcode Challenge: Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, 
return the minimal length of a subarray whose sum is greater than 
or equal to target. If there is no such subarray, return 0 instead.

7/13/24
Mark Robuck
"""
class Solution:
    """
    Determine if a subarray calculates to a certain value.
    Args:
        target(int): the amount the subarray sum is greater than or equal to
        nums(List[int]): list of integers provided
    Returns:
        int: minimal length of the subarray whose sum is >= target
    """
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        #empty list
        if n == 0:
            return 0
        
        #pointers using for a sliding window
        left = 0
        min_len = float('inf')
        sum = 0

        for right in range(n):
            #sum values from left to right
            sum += nums[right]
            #check for the target and shrink sliding window
            while sum >= target:
                min_len = min(min_len, right - left + 1)
                sum -= nums[left]
                left += 1

        if min_len == float('inf'):
            return 0
        else:
            return min_len
