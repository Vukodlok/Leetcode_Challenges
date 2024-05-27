"""
Leetcode Challenge: Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

5/7/24
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
    Check for null cases and call the function to check for symmetry recursively
    Args:
        p(TreeNode): one half of the tree
        q(TreeNode): the other half of the tree
    Returns:
        bool: true if p and q are mirrors of one another, false otherwise
    """
    def mirror(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        #check if both are emtpy      
        if p == None and q == None:
            return True
        #otherwise check if only one is empty
        elif p == None or q == None:
            return False
        #otherwise recursively check for symmetry
        else:
            return (p.val == q.val and self.mirror(p.left, q.right) and self.mirror(p.right, q.left))
            
    """
    Check for symmetry in the branches of a binary tree
    Args:
        root(TreeNode): binary tree to check
    Returns:
        bool: true if the left and right side of the tree are mirrors of one another, false otherwise
    """
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        #check if the tree is empty and return true
        if root == None:
            return True
        #check for symmetry in branches
        else:
            return self.mirror(root.left, root.right)
