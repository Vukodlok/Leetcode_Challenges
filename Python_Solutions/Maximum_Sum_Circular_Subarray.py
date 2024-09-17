"""
Leetcode Challenge: Maximum Sum Circular Subarray

Given a circular integer array nums of length n, 
return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the 
beginning of the array. Formally, the next element of nums[i] 
is nums[(i + 1) % n] and the previous element of nums[i] is 
nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums 
at most once. Formally, for a subarray nums[i], 
nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j 
with k1 % n == k2 % n.

9/17/24
Mark Robuck
"""

class Solution:
    """
    Find max possible sum of a subarray in a circular integer array.
    Args:
        nums(:ist[int]): original circular integer array
    Returns:
        int: max possible sum of a subarray of nums
    """
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        total_sum = sum(nums)

        #helper function to find max subarray sum (Kadane's algorithm)
        def kadane(arr):
            current_max = max_sum = arr[0]
            for num in arr[1:]:
                current_max = max(num, current_max + num)
                max_sum = max(max_sum, current_max)
            return max_sum

        #find maximum sum without circularity (normal Kadane's)
        max_kadane = kadane(nums)
        
        #find minimum subarray sum (inverted Kadane's) for circular case
        min_kadane = kadane([-num for num in nums])

        #handle the case where the minimum sum is equal to total_sum
        if sum(nums) == -min_kadane:
            return max_kadane
        
        #return the maximum of the normal max or circular max
        return max(max_kadane, total_sum + min_kadane)
