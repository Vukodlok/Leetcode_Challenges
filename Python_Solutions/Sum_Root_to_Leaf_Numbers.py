"""
Leetcode Challenge: Sum Root to Leaf Numbers

You are given the root of a binary tree containing digits from 0 to 9 only.
Each root-to-leaf path in the tree represents a number.
For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated 
so that the answer will fit in a 32-bit integer.
A leaf node is a node with no children.

8/19/24
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
    Find the number represented in root-to-leaf path of a binary tree and sum all values.
    Args:
        root(TreeNode): original tree root
    Returns:
        int: sum of all root-to-leaf values
    """
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        #perform a depth-first-search to traverse the tree
        def dfs(node, current_number):
            #base case
            if not node:
                return 0

            #update current number by appending node value
            current_number = current_number * 10 + node.val

            #if end of path return current number
            if not node.left and not node.right:
                return current_number

            #continue process for left and right children
            left_sum = dfs(node.left, current_number)
            right_sum = dfs(node.right, current_number)

            return left_sum + right_sum

        return dfs(root, 0)
