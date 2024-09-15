/*
* Leetcode Challenge: Construct Quad Tree
*
* Given a n * n matrix grid of 0's and 1's only. 
* We want to represent grid with a Quad-Tree.
*
* Return the root of the Quad-Tree representing grid.
*
* A Quad-Tree is a tree data structure in which each internal node 
* has exactly four children. Besides, each node has two attributes:
*
* val: True if the node represents a grid of 1's or False if the node 
* represents a grid of 0's. Notice that you can assign the val to 
* True or False when isLeaf is False, and both are accepted in the answer.
*
* isLeaf: True if the node is a leaf node on the tree or False if the 
* node has four children.
*
* class Node {
*     public boolean val;
*     public boolean isLeaf;
*     public Node topLeft;
*     public Node topRight;
*     public Node bottomLeft;
*     public Node bottomRight;
* }
*
* We can construct a Quad-Tree from a two-dimensional area using 
* the following steps:
*
* If the current grid has the same value (i.e all 1's or all 0's) set 
* isLeaf True and set val to the value of the grid and set the 
* four children to Null and stop.
*
* If the current grid has different values, set isLeaf to False and set 
* val to any value and divide the current grid into four sub-grids as 
* shown in the photo.
*
* Recurse for each of the children with the proper sub-grid.
*/

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    /*
    * Create the root of a quad-tree.
    * @params grid, original grid of 0s and 1s
    * @return the root of the quad-tree representing grid
    */
    public Node construct(int[][] grid) {
        int n = grid.length;
        return build(grid, 0, 0, n);
    }

    //function to check if grid contains the same values
    boolean isLeaf(int[][] grid, int x1, int y1, int length) {
        int value = grid[x1][y1];
        for (int i = x1; i < x1 + length; i++) {
            for (int j = y1; j < y1 + length; j++) {
                if (grid[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }

    //recursive function to build quad-tree
    Node build(int[][] grid, int x1, int y1, int length) {
        if (isLeaf(grid, x1, y1, length)) {
            return new Node(grid[x1][y1] == 1, true);
        }
        
        int half = length / 2;
        return new Node(
            //can be true or false when isLeaf is false
            true,
            false,
            build(grid, x1, y1, half),
            build(grid, x1, y1 + half, half),
            build(grid, x1 + half, y1, half),
            build(grid, x1 + half, y1 + half, half)
        );
    }
}
