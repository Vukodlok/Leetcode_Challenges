"""
Leetcode Challenge: Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, 
return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

9/20/24
Mark Robuck
"""

class Solution:
    """
    Merge two arrays then find the median element.
    Args:
        nums1(List[int]): list of integers
        nums2(List[int]): list of integers
    Returns:
        float: median of nums1 and nums2 merged together
    """
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        #ensure nums1 is the smaller array
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        m, n = len(nums1), len(nums2)
        low, high = 0, m
        
        #binary search using partitions of the lists ensuring left elements are smaller or equal to the right elements
        while low <= high:
            partition1 = (low + high) // 2
            partition2 = (m + n + 1) // 2 - partition1

            maxLeft1 = float('-inf') if partition1 == 0 else nums1[partition1 - 1]
            minRight1 = float('inf') if partition1 == m else nums1[partition1]

            maxLeft2 = float('-inf') if partition2 == 0 else nums2[partition2 - 1]
            minRight2 = float('inf') if partition2 == n else nums2[partition2]

            if maxLeft1 <= minRight2 and maxLeft2 <= minRight1:
                if (m + n) % 2 == 0:
                    return (max(maxLeft1, maxLeft2) + min(minRight1, minRight2)) / 2.0
                else:
                    return max(maxLeft1, maxLeft2)
            elif maxLeft1 > minRight2:
                high = partition1 - 1
            else:
                low = partition1 + 1
        
