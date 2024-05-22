"""
# Leetcode Challenge: Remove Element
#
# Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
# The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
# Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
# Change the array nums such that the first k elements of nums contain the elements which are not equal to val. 
# The remaining elements of nums are not important as well as the size of nums.
# Return k.
#
# 5/14/24
# Author: Mark Robuck
#
"""
class Solution:
    """
    Remove all occurrences of a value from an array
    Args:
        nums(List[int]): integer array of numbers to be checked for val
        val(int): integer to be checked for in nums and removed
    Returns: 
        integer value representing the number of elements in nums not equal to val
    """
    def removeElement(self, nums: List[int], val: int) -> int:
        #create left and right pointers
        left = 0
        right = len(nums) - 1
        #loop through nums
        while left <= right:
            #if an element equals val, swap it to the end
            if nums[left] == val:
                nums[left] = nums[right]
                right -= 1
            else:
                left += 1
        #return the length of the modified list
        return left

"""
# While debugging I found some more concise solutions involving list comprehension
# Use list comprehension to create a new list with elements not equal to val
    nums = [x for x in nums if x != val]
    # Return the length of the modified list
    return len(nums)
"""
