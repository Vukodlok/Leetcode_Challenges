"""
Leetcode Challenge: Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, 
return the kth smallest value (1-indexed) of all the values 
of the nodes in the tree.

8/26/24
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
    Return the kth smallest value in a binary tree using a stack.
    Args:
        root(TreeNode): original tree
        k(int): integer value of the cardinal number smallest value to return
    Returns:
        int: value of the kth smallest node
    """
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = []

        #traverse tree in-order
        while True:
            while root:
                stack.append(root)
                root = root.left

            #pop node from the stack
            root = stack.pop()
            k -= 1

            #if k becomes 0 we found the kth element
            if k == 0:
                return root.val

            root = root.right
        
