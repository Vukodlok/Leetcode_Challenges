"""
Leetcode Challenge: Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid 
binary search tree (BST).

A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less 
than the node's key.
The right subtree of a node contains only nodes with keys greater 
than the node's key.
Both the left and right subtrees must also be binary search trees.

8/27/24
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
    Determine if a binary tree is a valid binary search tree.
    Args:
        root(TreeNode): original tree
    Returns:
        bool: true if a valid BST, false otherwise
    """
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def validate(node, low=float('-inf'), high=float('inf')) -> bool:
            #an empty tree is a valid BST
            if not node:
                return True
            
            #current node value must be within the range of low and high
            if not (low < node.val < high):
                return False
            
            #recursively validate left and right subtrees with updated limits
            return (validate(node.left, low, node.val) and
                    validate(node.right, node.val, high))
        
        return validate(root)
