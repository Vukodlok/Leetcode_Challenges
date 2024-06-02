"""
Leetcode Challenge: Majority Element

 array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array.

6/2/24
Mark Robuck
"""
from collections import Counter

class Solution:
    """
    find the element in a list that appears at least half the time

    Args:
        nums(List[int]): list of ints to be checked
    Returns:
        int: the element that appears at least half the time
        - We are told this will always exist in our data
    """
    def majorityElement(self, nums: List[int]) -> int:
        #set a counter for each element
        counter = Counter(nums)
        #return the most common element
        return counter.most_common(1)[0][0]
