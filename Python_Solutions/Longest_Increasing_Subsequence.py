"""
Leetcode Challenge: Longest Increasing Subsequence

Given an integer array nums, return the length of the longest 
strictly increasing subsequence.

9/26/24
Mark Robuck
"""

class Solution:
    """
    Find length of longest increasing subsequence in an array.
    Args:
        nums(List[int]): array of integers to check
    Returns:
        int: length of longest strictly increasing subarray of nums
    """
    def lengthOfLIS(self, nums: List[int]) -> int:
        #base case: empty list
        if not nums:
            return 0
        
        #array to store length of the LIS at each index
        dp = [1] * len(nums)
        
        #iterate through nums to fill the dp array
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        
        return max(dp)
        
