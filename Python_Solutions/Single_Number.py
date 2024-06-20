"""
Leetcode Challenge: Single Number

Given a non-empty array of integers nums, every element appears twice except for one. 
Find that single one.
You must implement a solution with a linear runtime complexity 
and use only constant extra space.

6/20/24
Mark Robuck
"""
class Solution:
    """
    Find the unmatched intger in a list of pairs.
    Args:
        nums(List[int]): list of integer to be searched
    Returns:
        int: the only int in nums without a matching pair
    """
    def singleNumber(self, nums: List[int]) -> int:
        #create a list
        pairs = []
        #if a number is not in the list, put it in the list
        for i in nums:
            if i not in pairs:
                pairs.append(i)
        #if a number is in the list, remove it from the list
            else:
                pairs.remove(i)
        #after checking every number return the list, which only contains one number
        return pairs[0]
"""
#Optimal solution found afterwards

res = 0
        for n in nums:
            res = n ^ res
        return res
"""
