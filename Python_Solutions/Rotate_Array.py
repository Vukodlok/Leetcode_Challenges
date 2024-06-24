"""
Leetcode Challenge: Rotate Array

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

6/24/24
Mark Robuck
"""
class Solution:
    """
    Rotate all elements in anarray by k steps.
    Args:
        nums(List[int]): starting list of integers
    Do not return anything, modify nums in-place instead.
    """
    def rotate(self, nums: List[int], k: int) -> None:
        #make sure k is in the bounds of nums
        n = len(nums)
        k = k % n
        #rotate the start of the list and the end of the list, then join them
        nums[:] = nums[-k:] + nums[:-k]
