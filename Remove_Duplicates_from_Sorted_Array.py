"""
Leetcode Challenge: Remove Duplicates from Sorted Array

Given an integer array nums sorted in non-decreasing order, 
remove the duplicates in-place such that each unique element appears only once. 
The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the unique elements in the order they were
present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.

5/15/24
Mark Robuck
"""
class Solution:
    """
    Remove all duplicate values from the sorted array
    Args:
        nums (List[int]): list of integers in ascending order
    Returns:
        int: length of list after duplicates are removed
    """
    def removeDuplicates(self, nums: List[int]) -> int:
        # Use list comprehension to create a new list without duplicates
        unique_nums = [nums[i] for i in range(len(nums)) if i == len(nums) - 1 or nums[i] != nums[i+1]]
        # Update the original list to contain the unique elements
        nums[:] = unique_nums
        # Return the length of the modified list
        return len(nums)
'''This problem seemed very similar to Remove Element, which I recently solved.
I made use of the more efficient list comprehension solution I researched during
that challenge to solve this.'''
