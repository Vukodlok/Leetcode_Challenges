"""
Leetcode Challenge: Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of 
two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common 
ancestor is defined between two nodes p and q as the lowest node 
in T that has both p and q as descendants (where we allow a node 
to be a descendant of itself).”

8/20/24
Mark Robuck
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    """
    Find the lowest common ancestor in a binary tree.
    Args:
        root(TreeNode): original tree
        p(TreeNode): first of nodes to determine ancestor from
        q(TreeNode): second of nodes to determine ancestor from
    Returns:
        TreeNode: LCA node
    """
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #base case: if root is None, or root is one of p or q
        if not root or root == p or root == q:
            return root
        
        #recursively search for p and q in the left and right subtrees
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        #if p and q are found in different subtrees, root is their LCA
        if left and right:
            return root
        
        #otherwise, LCA is in that subtree
        return left if left else right
