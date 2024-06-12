"""
Leetcode Challenge: Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the 
longest path from the root node down to the farthest leaf node.

6/12/24
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
    Find the maximum depth of a binary tree.
    Args:
        root(TreeNode): the root node of the tree
    Returns:
        int: the maximum depth of the tree
    """
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        left_depth = 1
        right_depth = 1
        #base case of depth 0
        if root is None:
            return 0
        #recursive case, find the depth of left and right subtrees
        left_depth += self.maxDepth(root.left)
        right_depth += self.maxDepth(root.right)
        #max depth is the greater of the two subtree depths
        return max(left_depth, right_depth)
