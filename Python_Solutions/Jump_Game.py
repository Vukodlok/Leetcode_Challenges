"""
Leetcode Challenge: Jump Game

You are given an integer array nums. You are initially positioned 
at the array's first index, and each element in the array represents 
your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

6/26/24
Mark Robuck
"""
class Solution:
    """
    Determine if the entire array can be traversed given the game rules.
    Args:
        nums(List[int]): list of jump lengths
    Returns:
        bool: true if the end of the list can be reached, false otherwise
    """
    def canJump(self, nums: List[int]) -> bool:
        max_reach = 0
        for i in range(len(nums)):
            #current position is beyond max_reach
            if i > max_reach:
                return False
            #update max_reach
            max_reach = max(max_reach, i + nums[i])
            #max_reach is at or beyond last index
            if max_reach >= len(nums) - 1:
                return True
        return False
