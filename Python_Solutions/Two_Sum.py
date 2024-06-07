"""
Leetcode Challenge: Two Sum

Given an array of integers nums and an integer target, 
return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, 
and you may not use the same element twice.
You can return the answer in any order.

6/7/24
Mark Robuck
"""

class Solution:
    """
    Find the indices of two numbers that add up to a target sum.
    Args:
        nums(List[int]): list of possible numbers to add
        target(int): sum we are trying to find a combination for
    Returns:
        List[int]: return the two indices of the numbers with a sum of target
    We can assume exactly one solution and a number in nums is only used once.
    """
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #create a hashmap
        numbers = {}

        for i in range(len(nums)):
            value = nums[i]
            #check if the number in hashmap combined with existing numbers equals target
            if target - value in numbers:
                return numbers[target-value], i
            #if not found add to the hashmap
            else:
                numbers[value] = i
"""
During my research to fix my solution I found mention of enumerate, which is used to
iterate when both index and value are needed.

def twoSum(self, nums: List[int], target: int) -> List[int]:
    # Create a hashmap to store the value and its index
    numbers = {}

    for index, value in enumerate(nums):
        # Check if the complement of the current value is in the hashmap
        complement = target - value
        if complement in numbers:
            # Return the indices of the two numbers that add up to the target
            return [numbers[complement], index]
        # Store the current value and its index in the hashmap
        numbers[value] = index
"""
