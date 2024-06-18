"""
Leetcode Challenge: Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order, 
convert it to a height-balanced binary search tree.
A height-balanced binary tree is a binary tree in which the depth of the 
two subtrees of every node never differs by more than one.

6/18/24
Mark Robuck
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    Convert a sorted array into a binary tree.
    Args:
        nums(List[int]): integer list to be turned into a tree
    Returns:
        TreeNode: height-balanced binary tree made from nums
    """
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        #if list is empty
        if not nums:
            return None
        #find the middle spot
        mid = len(nums) // 2
        #start to build the tree from the middle, expanding left and right
        root = TreeNode(nums[mid])
        root.left = self.sortedArrayToBST(nums[:mid])
        root.right = self.sortedArrayToBST(nums[mid+1:])
        
        return root
