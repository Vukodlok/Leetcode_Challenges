# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def mirror(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        #check if both are emtpy      
        if p == None and q == None:
            return True
        #otherwise check if only one is empty
        elif p == None or q == None:
            return False
        #otherwise recursively check for symmetry
        else:
            return (p.val == q.val and self.mirror(p.left, q.right) and self.mirror(p.right, q.left))
            
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        #check if the tree is empty and return true
        if root == None:
            return True
        #check for symmetry in branches
        else:
            return self.mirror(root.left, root.right)
