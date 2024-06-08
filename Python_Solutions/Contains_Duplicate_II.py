"""
Leetcode Challenge: Contains Duplicate II

Given an integer array nums and an integer k, 
return true if there are two distinct indices i and j in the array such that 
nums[i] == nums[j] and abs(i - j) <= k.

6/8/24
Mark Robuck
"""
class Solution:
    """
    Check if a list contains two elements that are equals and k or less indices apart.
    Args:
        nums(List[int]): list of numbers to check
        k(int): max index distance the two matching values can be apart in the list
    Returns:
        bool: true if list contains a matching value that is also k or less indices apart
    """
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        #create a dictionary of values and indices
        numbers = {}
        #iterate through list
        for i, num in enumerate(nums):
            #if value is in the dictionary, and indices are within k places
            if num in numbers and i - numbers[num] <= k:
                return True
            #update index
            numbers[num] = i
        #if value is not in the dictionary or within k places of one another    
        return False
