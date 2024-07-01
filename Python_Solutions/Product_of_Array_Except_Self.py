"""
Leetcode Challenge: Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] 
is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to 
fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time 
and without using the division operation.

7/1/24
Mark Robuck
"""
class Solution:
    """
    Find the product of all elements in a list except at the current index.
    Args:
        nums(List[int]): original list if integers
    Returns:
        List[int]: factorial of each number up to the same index
    """
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        #create an intial list filled with ones and pointers
        result = [1] * len(nums)
        left = 1
        right = 1
        #pass through the list left to right
        for i in range(len(nums)):
            #grab the previous value
            result[i] = left
            #set each new left side value
            left *= nums[i]

        #pass through the list right to left
        for i in range(len(nums)-1, -1, -1):
            #grab the previous value
            result[i] *= right
            #set each new right side value, combined with the left side value
            right *= nums[i]
        
        return result
