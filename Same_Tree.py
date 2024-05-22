"""
Leetcode Challenge: Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

5/3/24
Mark Robuck

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
class Solution:
    """
    Check if two binary trees are equal in values and structure
    Args:
        p(TreeNode): first tree of the pair to check
        q(TreeNode): second tree of the pair to check
    Returns:
        bool: true if and q are the same values and structure, false otherwise
    """
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        #check if both trees are empty
        if (p == None and q == None):
            return True
        #check if only one tree is empty
        elif (p == None or q == None):
            return False
        #check if values are different
        elif (p.val != q.val):
            return False
        #recursively compare values
        return (Solution().isSameTree(p.left, q.left) and Solution().isSameTree(p.right, q.right))
        
#################################
#A cleaned up version from the solutions that has a much better runtime
'''
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q: # identify the p and q are not null
            return True
        if not p or not q or p.val != q.val:
            return False
        return (self.isSameTree(p.left, q.left) and
                self.isSameTree(p.right,q.right))
'''
