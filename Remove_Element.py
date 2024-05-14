class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        #create left and right pointers
        left = 0
        right = len(nums) - 1
        #loop through nums
        while left <= right:
            #if an element equals val, swap it to the end
            if nums[left] == val:
                nums[left] = nums[right]
                right -= 1
            else:
                left += 1
        #return the length of the modified list
        return left

'''
#While debugging I found some more concise solutions involving list comprehension
# Use list comprehension to create a new list with elements not equal to val
    nums = [x for x in nums if x != val]
    # Return the length of the modified list
    return len(nums)
'''
