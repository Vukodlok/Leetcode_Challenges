"""
Leetcode Challenge: Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of 
adjacent nodes in the sequence has an edge connecting them. A node 
can only appear in the sequence at most once. Note that the path 
does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of 
any non-empty path.

8/22/24
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
    Find the max path sum.
    Args:
        root(TreeNode): original tree
    Returns:
        int: max path sum as an integer
    """
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.max_sum = float('-inf')

        def max_gain(node):
            #base case
            if not node:
                return 0
            
            #recursive case
            #calculate through left and right children, ignoring negatives
            left_gain = max(max_gain(node.left), 0)
            right_gain = max(max_gain(node.right), 0)

            #calculate passing through current node
            price_newpath = node.val + left_gain + right_gain

            #update max path sum
            self.max_sum = max(self.max_sum, price_newpath)

            return node.val + max(left_gain, right_gain)

        max_gain(root)
        return self.max_sum
            
