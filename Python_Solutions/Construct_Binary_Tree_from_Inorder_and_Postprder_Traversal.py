"""
Leetcode Challenge: Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the 
inorder traversal of a binary tree and postorder is the postorder 
traversal of the same tree, construct and return the binary tree.

8/15/24
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
    Construct Binary Tree given the inorder, by column, and postprder list of integers.
    Args:
        inorder(List[int]): list of integers as inorder nodes
        postorder(List[int]): list of integers as postorder nodes
    Returns:
        TreeNode: constructed binary tree of integer values
    """
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        #empty lists
        if not inorder or not postorder:
            return None

        #create root of tree
        root_val = postorder.pop()
        root = TreeNode(root_val)

        #find the index of the root from inorder
        inorder_index = inorder.index(root_val)

        #recursively construct left and right tree
        root.right = self.buildTree(inorder[inorder_index + 1:], postorder)
        root.left = self.buildTree(inorder[:inorder_index], postorder)

        return root
