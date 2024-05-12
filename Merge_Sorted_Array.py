class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
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
