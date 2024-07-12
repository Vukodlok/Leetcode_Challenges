"""
Leetcode Challenge: 3Sum

Given an integer array nums, return all the triplets 
[nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, 
and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

7/12/24
Mark Robuck
"""
class Solution:
    """
    Find all triplets in a list that sum to zero.
    Args:
        nums(List[int]): list of integers to check
    Returns:
        List[int]: list of lists containing the indices of values with a sum of zero
    """
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        #less than 3 numbers in the list
        if len(nums) < 3:
            return []
        #create pointers
        nums.sort()
        zero_sums = []

        #loop through nums
        for i in range(len(nums) - 2):
            #skip duplicates for 1st value
            if i > 0 and nums[i] == nums[i-1]:
                continue
            left = i + 1
            right = len(nums) - 1
            #look for triplet zero sums
            while left < right:
                total = nums[i] + nums[left] + nums[right]
                if total == 0:
                    zero_sums.append([nums[i], nums[left], nums[right]])
                    #skip duplicate values for 2nd and 3rd values
                    while left < right and nums[left] == nums[left+1]:
                        left += 1
                    while left < right and nums[right] == nums[right-1]:
                        right -= 1
                    #move pointers
                    left += 1
                    right -= 1
                elif total < 0:
                    left += 1
                else:
                    right -= 1
        return zero_sums
