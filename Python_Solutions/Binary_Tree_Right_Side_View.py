"""
Leetcode Challenge: Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the 
right side of it, return the values of the nodes you can see ordered 
from top to bottom.

8/23/24
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
    Return the "right" side of the tree.
    Args:
        root(TreeNode): original tree
    Returns:
        List[int]: list of integers of the right side of the tree
    """
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        #empty tree
        if not root:
            return []

        #breadth-first search to traverse tree level by level
        right_side = []
        queue = deque([root])
        
        while queue:
            level_length = len(queue)
            
            for i in range(level_length):
                node = queue.popleft()

                #if the last node in a level add to right list
                if i == level_length - 1:
                    right_side.append(node.val)

                #add child node to queue
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        
        return right_side
