"""
Leetcode Challenge: Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, 
find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

9/19/24
Mark Robuck
"""

class Solution:
    """
    Find the first and last position of an element in a sorted list.
    Args:
        nums(List[int]): sorted list of integers
        target(int): the integer to search for
    Returns: 
        List[int]: all indices target is at in nums
    """
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        #helper function to find the leftmost and rightmost occurances
        def findBound(isFirst: bool) -> int:
            low, high = 0, len(nums) - 1
            while low <= high:
                mid = (low + high) // 2
                if nums[mid] == target:
                    if isFirst:
                        if mid == low or nums[mid - 1] != target:
                            return mid
                        high = mid - 1
                    else:
                        if mid == high or nums[mid + 1] != target:
                            return mid
                        low = mid + 1
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return -1
        #use helper function to find leftmost bound
        first_pos = findBound(True)
        if first_pos == -1:
            #target not found
            return [-1, -1]
        #use helper function to find righmost bound
        last_pos = findBound(False)
        return [first_pos, last_pos]
