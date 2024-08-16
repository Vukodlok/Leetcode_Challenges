"""
Leetcode Challenge: Populating Next Right Pointers in Each Node II

Given a binary tree, populate each next pointer to point to its next 
right node. If there is no next right node, the next pointer should 
be set to NULL.

Initially, all next pointers are set to NULL.

8/16/24
Mark Robuck
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    """
    Set nodes to the right of existing nodes in binary tree.
    Args:
        root(Node): original tree root
    Returns:
        binary tree with all "right node" pointers set
    """
    def connect(self, root: 'Node') -> 'Node':
        #empty tree
        if not root:
            return None

        current = root
        while current:
            #dummy node for handling next connection
            dummy = Node(0)
            tail = dummy

            #traverse nodes at current level
            while current:
                if current.left:
                    tail.next = current.left
                    tail = tail.next
                if current.right:
                    tail.next = current.right
                    tail = tail.next
            
                current = current.next

            #move to next level
            current = dummy.next

        return root
