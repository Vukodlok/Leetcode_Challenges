"""
Leetcode Challenge: Longest Consecutive Sequence

Given an unsorted array of integers nums, 
return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

7/25/24
Mark Robuck
"""

class Solution:
    """
    Find the longest sequence of consecutive numbers in a list.
    Args:
        nums(List[int]): original given list
    Returns:
        int: length of longest consecutive sequence
    """
    def longestConsecutive(self, nums: List[int]) -> int:
        #empty list
        if not nums:
            return 0

        #create a set from the list
        nums_set = set(nums)
        max_count = 0

        #iterate through the list
        for num in nums_set:
            #check for start of a sequence
            if num - 1 not in nums_set:
                #update variables
                current_num = num
                current_count = 1

                #check for consecutive sequence
                while current_num + 1 in nums_set:
                    current_num += 1
                    current_count += 1
                
                #find the longest sequence
                max_count = max(max_count, current_count)

        return max_count
