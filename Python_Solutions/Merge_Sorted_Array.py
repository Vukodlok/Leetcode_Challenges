''' 
# Leetcode challenge: Merge Sorted Array
#
# You are given two integer arrays nums1 and nums2, sorted in ascending order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
# Merge nums1 and nums2 into a single array sorted in ascending order.
# The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
# To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
# and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
#
# Created: 5/14/24
# Author: Mark Robuck
'''
class Solution:
    '''
    # Merge two sorted arrays back into the first array, in ascending order
    @param nums1, sorted array of m integer elements followed by n integer elements set to zero
    @param nums2, sorted array of n integer elements
    @param m, number of sorted elements at the front portion of nums1
    @param n, number of sorted elements in nums2, and the number of empty 0 elements at the back portion of nums1
    '''
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        #checks if both lists contain values
        if len(nums2) > 0 and len(nums1) > n:
            #last element of nums1
            i = m - 1
            #last element of nums2
            j = n - 1
            #element where merged values are placed
            spot = m + n - 1
            #repeat until nums1 is a merged sorted list
            while j >= 0:
                #if nums1 value is larger add to end of list and move i back one
                if i >= 0 and nums1[i] > nums2[j]:
                    nums1[spot] = nums1[i]
                    i -= 1
                #if nums2 value is larger add to end of list and move j back one
                else:
                    nums1[spot] = nums2[j]
                    j -= 1
                spot -= 1
        #checks if only nums1 contains values and sets nums1 to the m portion only
        elif len(nums2) <= 0:
            nums1[:] = nums1[0:m]
        #checks if only nums2 conatins values and copies those values over to nums1
        elif len(nums1) <= n:
            for j in range(n):
                nums1[j] = nums2[j]
        #check if both nums1 and nums2 are empty and sets nums1 to null
        else:
            nums1 = null

'''
On looking at other solutions I found a much simplier solution than mine.
Copy the first n elements from nums1 and the elements of nums2 into a new array,
then call a premade sort method.
'''
