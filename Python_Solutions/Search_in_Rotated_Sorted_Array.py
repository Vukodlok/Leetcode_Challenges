"""
Leetcode Challenge: Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated 
at an unknown pivot index k (1 <= k < nums.length) such that the 
resulting array is [nums[k], nums[k+1], ..., nums[n-1], 
nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, 
[0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, 
return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

9/18/24
Mark Robuck
"""

class Solution:
    """
    Find the index of a given integer in an array that has been rotated.
    Args:
        nums(List[int]): list of integers after it has been rotated
        target(int): the integer to find in nums
    Returns:
        the index of target in nums
    """
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        
        while left <= right:
            mid = (left + right) // 2

            #if middle element is target
            if nums[mid] == target:
                return mid

            #left portion is sorted
            if nums[left] <= nums[mid]:
                #check if target is within the sorted left portion
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            #right portion is sorted
            else:
                #check if target is within the sorted right portion
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        
        return -1
