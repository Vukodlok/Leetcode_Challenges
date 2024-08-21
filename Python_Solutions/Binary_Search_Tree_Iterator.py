"""
Leetcode Challenge: Binary Search Tree Iterator

Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. 
The root of the BST is given as part of the constructor. The pointer should 
be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal 
to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at 
the pointer.
Notice that by initializing the pointer to a non-existent smallest number, 
the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, 
there will be at least a next number in the in-order traversal when 
next() is called.

8/21/24
Mark Robuck
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

class BSTIterator:
    """
    Initialize an object of the BSTIterator class.
    Args:
        root(TreeNode): original root
    """
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self._leftmost_inorder(root)
    
    #helper function to push all left nodes to the stack
    def _leftmost_inorder(self, root):
        while root:
            self.stack.append(root)
            root = root.left
        
    """
    Move the pointer right.
    Returns:
        int: number at the pointer
    """
    def next(self) -> int:
        #node at the top of the stack is the next smallest element
        topmost_node = self.stack.pop()
        #if the node has a right child, traverse its leftmost branch
        if topmost_node.right:
            self._leftmost_inorder(topmost_node.right)
        return topmost_node.val
        
    """
    Checks for an existing next node.
    Returns:
        bool: true if a number exists in the traversal to the right of pointer,
        false otherwise
    """
    def hasNext(self) -> bool:
        return len(self.stack) > 0
