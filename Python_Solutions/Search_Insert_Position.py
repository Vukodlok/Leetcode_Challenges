"""
Leetcode Challenge: Search Insert Position

Given a sorted array of distinct integers and a target value, 
return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

6/19/24
Mark Robuck
"""
class Solution:
    """
    Binary search for a value and return the index where it is or should be if missing.
    Args:
        nums(List[int]): list of integers to search
    Returns:
        int: if in list index of searched for value, otherwise index value should be in
    """
    def searchInsert(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        while left <= right:
            #set the current middle of the list
            mid = left + (right - left) // 2
            #is target at mid
            if nums[mid] == target:
                return mid
            #is target greater
            elif nums[mid] < target:
                left = mid + 1
            #is target less
            else:
                right = mid - 1
        #return insertion point if value not in list
        return left
