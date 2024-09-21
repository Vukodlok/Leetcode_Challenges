"""
Leetcode Challenge: Find K Pairs with Smallest Sums

You are given two integer arrays nums1 and nums2 sorted in 
non-decreasing order and an integer k.

Define a pair (u, v) which consists of one element from the first 
array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

9/21/24
Mark Robuck
"""
import heapq
from typing import List

class Solution:
    """
    Find pairs of values from two lists in order of smallest sum
    Args:
        nums1(List[int]): list of sorted integers
        nums2(List[int]): list of sorted integers
        k(int): number of pairs to return
    Return:
        List[int]: pairs of integers from nums1, nums2 in order of smallest sum
    """
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        #min-heap for maintaining the smallest sum pairs
        min_heap = []
        result = []
        
        #edge cases
        if not nums1 or not nums2 or k == 0:
            return result
        
        #add the first k pairs from nums1[0] and all of nums2
        for i in range(min(k, len(nums1))):
            heapq.heappush(min_heap, (nums1[i] + nums2[0], i, 0))
        
        #extract k smallest pairs
        while k > 0 and min_heap:
            current_sum, i, j = heapq.heappop(min_heap)
            result.append([nums1[i], nums2[j]])
            k -= 1
            
            #if possible, push the next pair (nums1[i], nums2[j+1]) into the heap
            if j + 1 < len(nums2):
                heapq.heappush(min_heap, (nums1[i] + nums2[j+1], i, j+1))
        
        return result
        
