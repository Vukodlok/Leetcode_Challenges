"""
Leetcode Challenge: Kth Largest Element in an Array

Given an integer array nums and an integer k, 
return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, 
not the kth distinct element.
Can you solve it without sorting?

9/20/24
Mark Robuck
"""
import heapq

class Solution:
    """
    Find the kth largest element in an unsorted list.
    Args:
        nums(List[int]): list of unsorted integers
        k(int): index of the integer to be found if sorted
    Returns:
        int: value of the kth largest element
    """
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #use a min-heap to efficiently find the kth largest element
        return heapq.nlargest(k, nums)[-1]
