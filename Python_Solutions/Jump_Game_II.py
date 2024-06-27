"""
Leetcode Challenge: Jump Game II

You are given a 0-indexed array of integers nums of length n. 
You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump 
from index i. In other words, if you are at nums[i], 
you can jump to any nums[i + j] where:
0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. 
The test cases are generated such that you can reach nums[n - 1].

6/27/24
Mark Robuck
"""

class Solution:
    """
    Find minimum number of jumps to reach the end of an array. 
    Each element represents the max jump distance from that index.
    Args:
        nums(List[int]): given list of max jump lengths
    Returns:
        int: min number of jumps to reach the end of the list
    """
    def jump(self, nums: List[int]) -> int:        
        n = len(nums)
        jumps = 0
        current_end = 0
        farthest = 0

        #only one element in list
        if n < 2:
            return 0
        
        for i in range(n-1):
            #track farthest possible jump
            farthest = max(farthest, i + nums[i])
            #if at the farthest jump for the index, make a jump
            if i == current_end:
                jumps += 1
                current_end = farthest
                #break the loop when we reach the end of the list
                if current_end >= n-1:
                    break

        return jumps
