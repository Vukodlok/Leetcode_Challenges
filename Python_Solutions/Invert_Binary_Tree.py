"""
Leetcode Challenge: Invert Binary Tree

Given the root of a binary tree, invert the tree, and return its root.

6/13/24
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
    Invert a binary tree.
    Args:
        root(TreeNode): initial binary tree
    Returns:
        TreeNode: root inverted
    """
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        #check for empty tree
        if root is None:
            return root
        #swap the left and right children
        else:
            temp = root.left
            root.left = root.right
            root.right = temp
            #recursively invert subtrees
            self.invertTree(root.left)
            self.invertTree(root.right)
        return root

# A more efficient version removed the else, which was redundant
