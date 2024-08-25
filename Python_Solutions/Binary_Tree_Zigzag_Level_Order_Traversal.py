"""
Leetcode Challenge: Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal 
of its nodes' values. (i.e., from left to right, then right to left for 
the next level and alternate between).

8/25/24
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
    Return nodes of binary tree in zagzag level order, left-right-left-etc.
    Args:
        root[TreeNode]: original tree
    Returns:
        List[int]: list of integer node values in zigzag level order
    """
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        #empty tree
        if not root:
            return []

        result = []
        queue = deque([root])
        #initialize direction
        left_to_right = True
        
        while queue:
            #number of nodes at the current level
            level_size = len(queue)
            level_nodes = deque()
            
            #process each node in the current level
            for _ in range(level_size):
                #get the next node from the queue
                node = queue.popleft()
                
                #append node value depending on the current direction
                if left_to_right:
                    level_nodes.append(node.val)
                else:
                    level_nodes.appendleft(node.val)

                #add children to queue
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            #flip direction after processing
            left_to_right = not left_to_right
            result.append(list(level_nodes))
        
        return result
