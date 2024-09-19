"""
Leetcode Challenge: Find Minimum in Rotated Sorted Array

Suppose an array of length n sorted in ascending order is rotated 
between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] 
might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 
1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, 
return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.

9/19/24
Mark Robuck
"""

class Solution:
    """
    Find the mimimum element in a list that has been rotated multiple times.
    Args:
        nums(List[int]): list rotated multiple times
    Returns:
        int: minimum element in nums
    """
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1
        
        #binary search
        while low < high:
            mid = (low + high) // 2
            
            #if middle element > than the last element, smallest value in right half.
            if nums[mid] > nums[high]:
                low = mid + 1
            # Otherwise, smallest value in left half (including mid).
            else:
                high = mid
        
        return nums[low]
        
