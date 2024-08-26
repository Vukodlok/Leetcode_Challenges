/*
* Leetcode Challenge: Kth Smallest Element in a BST
*
* Given the root of a binary search tree, and an integer k, 
* return the kth smallest value (1-indexed) of all the values 
* of the nodes in the tree.
*
* 8/26/24
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
class Solution {
    /*
    * Return the kth smallest value in a binary tree using a stack.
    * @params root, original tree
    * @params k, integer value of the cardinal number smallest value to return
    * @return value of the kth smallest node
    */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        //traverse tree in-order
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            //pop node from the stack
            root = stack.pop();
            k--;

            //if k becomes 0 we found the kth element
            if (k == 0) {
                return root.val;
            }

            root = root.right;
        }
    }
}
