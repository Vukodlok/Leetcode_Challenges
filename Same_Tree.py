# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        #check if both trees are empty
        if (p == None and q == None):
            return True
        #check if only one tree is empty
        elif (p == None or q == None):
            return False
        #check if values are different
        elif (p.val != q.val):
            return False
        #recursively compare values
        return (Solution().isSameTree(p.left, q.left) and Solution().isSameTree(p.right, q.right))
