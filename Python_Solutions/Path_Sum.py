"""
Leetcode Challeneg: Path Sum

Given the root of a binary tree and an integer targetSum, 
return true if the tree has a root-to-leaf path such that 
adding up all the values along the path equals targetSum.
A leaf is a node with no children.

6/14/24
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
    Check if a binary tree has a root-to-leaf path with a specific int sum.
    Args:
        root(TreeNode): the binary tree to be checked
        targetSum(int): the sum being checked for
    Returns:
        bool: true if a root-to-leaf path exists with a sum of targetSum, false otherwise
    """
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        #empty tree
        if root is None:
            return False
        #if we reach a leaf node, check if the current value equals targetSum
        if not root.left and not root.right:
            return targetSum == root.val
        #recursively check the left and right subtrees with the updated targetSum
        new_target = targetSum - root.val
        return self.hasPathSum(root.left, new_target) or self.hasPathSum(root.right, new_target)
