"""
Leetcode Challenge: Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the 
preorder traversal of a binary tree and inorder is the inorder traversal 
of the same tree, construct and return the binary tree.

8/14/24
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
    Given the preorder, by row, and inorder, by column, list of integers
    construct the binary tree.
    Args:
        preorder(List[int]): integers ordered top to bottom
        inorder(List[int]): integers ordered left to right
    Returns:
        TreeNode: completed binary tree
    """
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        #empty tree
        if not preorder or not inorder:
            return None
        
        #set root using first element of preorder
        root_val = preorder.pop(0)
        root = TreeNode(root_val)

        #find index of root using inorder
        inorder_index = inorder.index(root_val)

        #elements left of inorder_index belong to the left subtree
        #elements right of inorder_index belong to the right subtree
        root.left = self.buildTree(preorder, inorder[:inorder_index])
        root.right = self.buildTree(preorder, inorder[inorder_index + 1:])
        
        return root
