"""
Leetcode Challenge: Minimum Absolute Difference in BST

Given the root of a Binary Search Tree (BST), return the minimum absolute difference 
between the values of any two different nodes in the tree.

6/17/24
Mark Robuck
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev = None
    min = float('inf')
    """
    Find the min absolute value difference for any two values in a binary tree.
    Args:
        root(TreeNode): tree to check
    Returns:
        int: min absolute value difference
    """
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        #empty tree
        if root is None:
            return
        #traverse left subtree
        if root.left is not None:
            self.getMinimumDifference(root.left)
        #process current node
        if self.prev is not None:
            self.min = min(self.min, root.val - self.prev)
        self.prev = root.val
        #traverse right subtree
        if root.right is not None:
            self.getMinimumDifference(root.right)

        return self.min
