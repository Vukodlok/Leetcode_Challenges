"""
Leetcode Challenge: Construct Quad Tree

Given a n * n matrix grid of 0's and 1's only. We want to represent grid with a Quad-Tree.

Return the root of the Quad-Tree representing grid.

A Quad-Tree is a tree data structure in which each internal node 
has exactly four children. Besides, each node has two attributes:

val: True if the node represents a grid of 1's or False if the node 
represents a grid of 0's. Notice that you can assign the val to 
True or False when isLeaf is False, and both are accepted in the answer.

isLeaf: True if the node is a leaf node on the tree or False if the 
node has four children.

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;
}

We can construct a Quad-Tree from a two-dimensional area using 
the following steps:

If the current grid has the same value (i.e all 1's or all 0's) set 
isLeaf True and set val to the value of the grid and set the 
four children to Null and stop.

If the current grid has different values, set isLeaf to False and set 
val to any value and divide the current grid into four sub-grids as 
shown in the photo.

Recurse for each of the children with the proper sub-grid.
"""

"""
# Definition for a QuadTree node.
class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""

class Solution:
    """
    Create the root of a quad-tree.
    Args:
        grid(List[int]): original grid of 0s and 1s
    Returns:
        the root of the quad-tree representing grid
    """
    def construct(self, grid: List[List[int]]) -> 'Node':
        #function to check if grid contains the same values
        def isLeaf(x1, y1, length):
            value = grid[x1][y1]
            for i in range(x1, x1 + length):
                for j in range(y1, y1 + length):
                    if grid[i][j] != value:
                        return False, None
            return True, value

        #recursive function to build quad-tree
        def build(x1, y1, length):
            leaf, val = isLeaf(x1, y1, length)
            if leaf:
                return Node(val == 1, True)
            
            half = length // 2
            return Node(
                #can be true or false when isLeaf is false
                val=True,
                isLeaf=False,
                topLeft=build(x1, y1, half),
                topRight=build(x1, y1 + half, half),
                bottomLeft=build(x1 + half, y1, half),
                bottomRight=build(x1 + half, y1 + half, half)
            )
        
        n = len(grid)
        return build(0, 0, n)
