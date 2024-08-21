/*
* Leetcode Challenge: Binary Search Tree Iterator
*
* Implement the BSTIterator class that represents an iterator over 
* the in-order traversal of a binary search tree (BST):
* 
* BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. 
* The root of the BST is given as part of the constructor. The pointer should 
* be initialized to a non-existent number smaller than any element in the BST.
* boolean hasNext() Returns true if there exists a number in the traversal 
* to the right of the pointer, otherwise returns false.
* int next() Moves the pointer to the right, then returns the number at 
* the pointer.
* Notice that by initializing the pointer to a non-existent smallest number, 
* the first call to next() will return the smallest element in the BST.
*
* You may assume that next() calls will always be valid. That is, 
* there will be at least a next number in the in-order traversal when 
* next() is called.
*
* 8/21/24
* Mark Robuck
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    /*
    * Initialize an object of the BSTIterator class.
    * @params root, original root
    */
    public BSTIterator(TreeNode root) {
        _leftmostInorder(root);
    }
    
    //helper function to push all left nodes to the stack
    private void _leftmostInorder(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
        
    /*
    * Move the pointer right.
    * @returns integer number at the pointer
    */
    public int next() {
        //node at the top of the stack is the next smallest element
        TreeNode topmostNode = stack.pop();
        //if the node has a right child, traverse its leftmost branch
        if (topmostNode.right != null) {
            _leftmostInorder(topmostNode.right);
        }
        return topmostNode.val;
    }
        
    /*
    * Checks for an existing next node.
    * @return true if a number exists in the traversal to the right of pointer,
    *    false otherwise
    */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
