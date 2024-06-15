"""
Leetcode Challenge: Count Complete Tree Nodes

Given the root of a complete binary tree, return the number of the nodes in the tree.
According to Wikipedia, every level, except possibly the last, is completely filled 
in a complete binary tree, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.
Design an algorithm that runs in less than O(n) time complexity.

6/15/24
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
    Count the number of nodes in a binary treee.
    Args:
        root(TreeNode): binary tree to count
    Returns:
        int: number of nodes in a tree
    """
    def countNodes(self, root: Optional[TreeNode]) -> int:
        #empty tree
        if root is None:
            return 0
        #count existing nodes recursively, plus one for root node
        return self.countNodes(root.left) + self.countNodes(root.right) + 1
