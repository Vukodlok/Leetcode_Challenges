'''This problem seemed very similar to Remove Element, which I recently solved.
I made use of the more efficient list comprehension solution I researched during
that challenge to solve this.'''
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # Use list comprehension to create a new list without duplicates
        unique_nums = [nums[i] for i in range(len(nums)) if i == len(nums) - 1 or nums[i] != nums[i+1]]
        # Update the original list to contain the unique elements
        nums[:] = unique_nums
        # Return the length of the modified list
        return len(nums)
