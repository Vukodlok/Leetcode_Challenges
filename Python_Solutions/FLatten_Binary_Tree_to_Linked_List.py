"""
Leetcode Challenge: Flatten Binary Tree to Linked List

Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the 
right child pointer points to the next node in the list and 
the left child pointer is always null. The "linked list" should be in 
the same order as a pre-order traversal of the binary tree.

Do not return anything, modify root in-place instead.

8/17/24
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
    Turn a binary tree into a linked list in pre-order traversal.
    Args:
        root(TreeNode): original tree
    """
    def flatten(self, root: Optional[TreeNode]) -> None:
        #empty tree
        if not root:
            return

        # pointer for tracking previous node
        prev = None
        
        def flatten_tree(node: Optional[TreeNode]):
            nonlocal prev
            if not node:
                return None

            #recursively flatten left and right subtrees
            flatten_tree(node.right)
            flatten_tree(node.left)

            #point right to next and left to none
            node.right = prev
            node.left = None
            prev = node

        flatten_tree(root)
            
