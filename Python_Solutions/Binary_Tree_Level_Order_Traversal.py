"""
Leetcode Challenge: Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal 
of its nodes' values. (i.e., from left to right, level by level).

8/24/24
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
    Return node values of a binary tree in left to right level order.
    Args:
        root(TreeNode): original tree
    Returns:
        List[int]: integer list of node value in left to right level order
    """
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        #empty tree
        if not root:
            return []

        result = []
        queue = deque([root])
        
        while queue:
            level_size = len(queue)
            level_nodes = []
            
            for _ in range(level_size):
                node = queue.popleft()
                level_nodes.append(node.val)
                
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            result.append(level_nodes)
        
        return result
        
