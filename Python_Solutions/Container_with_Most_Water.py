""" 
Leetcode Challenge: Container with Most Water

You are given an integer array height of length n. 
There are n vertical lines drawn such that the two endpoints 
of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, 
such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

7/11/24
Mark Robuck
"""
class Solution:
    """
    Find the max amount of area given an area of heights.
    Args:
        height(List[int]): list of heights to contain water
    Returns:
        int: max amount of water able to be held between two "walls"
    """
    def maxArea(self, height: List[int]) -> int:
        #if one or less heights in list
        if len(height) < 2:
            return 0
        left= 0
        right = len(height) - 1
        max_area = 0
        
        while left < right:
            #calculate width between left and right pointers
            width = right - left 
            #calculate width between left and right heights
            current_area = min(height[left], height[right]) * width
            #check if current area is the new max
            max_area = max(max_area, current_area)
            #move the shorter pointer
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return max_area
