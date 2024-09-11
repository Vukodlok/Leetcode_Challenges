"""
Leetcode Challenge: Permutations

Given an array nums of distinct integers, return all the possible 
permutations. You can return the answer in any order.

9/11/24
Mark Robuck
"""

class Solution:
    """
    Find all permutations of a set of integers.
    Args:
        nums(List[int]): given set of integers
    Returns:
        List[int]: list of all possible permutations of nums
    """
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []

        #helper function to generate permutations
        def backtrack (current_permutation, remaining_nums):
            #if no numbers left, permutation complete
            if not remaining_nums:
                result.append(current_permutation)
                return

            #iterate over remaining numbers and form permutations
            for i in range(len(remaining_nums)):
                backtrack(current_permutation + [remaining_nums[i]], remaining_nums[:i] + remaining_nums[i+1:])

        backtrack([], nums)
        return result
        
