"""
Leetcode Challenge: Summary Ranges

You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

6/9/24
Mark Robuck
"""

class Solution:
    """
    Return a formatted string representing a range of numbers in a list.
    Args:
        nums(List[int]): list of integers to be formatted
    Returns:
        List[str]: formatted list of nums
    """
    def summaryRanges(self, nums: List[int]) -> List[str]:
        result = []

        if not nums:
            return result

        start = nums[0]

        for i in range(1, len(nums)):
            #check for nonconsecutive values, and close the range
            if nums[i] != nums[i-1] + 1:
                if start == nums[i-1]:
                    result.append(str(start))
                #if consecutive add range number
                else:
                    result.append(f"{start}->{nums[i-1]}")
                #iterate to next range
                start = nums[i]

        #add the final range to result
        if start == nums[-1]:
            result.append(str(start))
        else:
            result.append(f"{start}->{nums[-1]}")
        
        return result
