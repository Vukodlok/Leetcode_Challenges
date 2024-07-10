"""
Leetcode Challenge: Two Sum II - Input Array Is Sorted

Given a 1-indexed array of integers numbers that is 
already sorted in ascending order, find two numbers 
such that they add up to a specific target number. 
Let these two numbers be numbers[index1] and numbers[index2] 
where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one 
as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. 
You may not use the same element twice.
Your solution must use only constant extra space.

7/10/24
Mark Robuck
"""
class Solution:
    """
    Find the index of two numbers in an array that add to a target sum.
    Args:
        numbers(List[int]): list of integers
        target(int): sum of the two target numbers to be found
    Returns:
        List[int]: an array of the index + 1 of each of the target numbers
    """
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # Create a hashmap to store the value and its index
        nums = {}

        for index, value in enumerate(numbers):
            # Check if the complement of the current value is in the hashmap
            complement = target - value
            if complement in nums:
                # Return the indices of the two numbers that add up to the target
                return [nums[complement] + 1, index + 1]
            # Store the current value and its index in the hashmap
            nums[value] = index
