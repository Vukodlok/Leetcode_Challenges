"""
Leetcode Challenge: Average of Levels in Binary Tree

Given the root of a binary tree, return the average value of the nodes on each level 
in the form of an array. Answers within 10^-5 of the actual answer will be accepted.

6/16/24
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
    Average the node values of each level of a binary tree.
    Args:
        root(TreeNode): given tree to find averages for
    Returns:
        List(float): average of each level as a list
    """
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        averages = []
        queue = [root]
        #if the tree is empty
        if not root:
            return averages
        
        while queue:
            level_sum = 0
            level_count = len(queue)
            next_queue = []
            #sum single level in the tree
            for node in queue:
                level_sum += node.val
                #add next level of nodes to the next queue
                if node.left:
                    next_queue.append(node.left)
                if node.right:
                    next_queue.append(node.right)
            #calculate average for the level and append to the list
            averages.append(level_sum / level_count)
            #move to the next level of nodes
            queue = next_queue
        
        return averages
