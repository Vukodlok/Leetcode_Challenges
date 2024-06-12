/*
* Leetcode Challenge: Maximum Depth of Binary Tree
*
* Given the root of a binary tree, return its maximum depth.
* A binary tree's maximum depth is the number of nodes along the 
* longest path from the root node down to the farthest leaf node.
*
* 6/12/24
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
    * Find the maximum depth of a binary tree.
    * @params root, the root node of the tree
    * @return, the maximum depth of the tree as an int
    */
    public int maxDepth(TreeNode root) {
        int leftDepth = 1;
        int rightDepth = 1;
        //base case of depth 0
        if (root == null) {
            return 0;
        }
        //recursive case, find the depth of left and right subtrees
        leftDepth += this.maxDepth(root.left);
        rightDepth += this.maxDepth(root.right);
        //max depth is the greater of the two subtree depths
        return Math.max(leftDepth, rightDepth);       
    }
}
