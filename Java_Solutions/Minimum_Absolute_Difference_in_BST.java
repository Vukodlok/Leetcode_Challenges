/*
* Leetcode Challenge: Minimum Absolute Difference in BST
*
* Given the root of a Binary Search Tree (BST), return the minimum absolute difference 
* between the values of any two different nodes in the tree.
*
* 6/17/24
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
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;
    /*
    * Find the min absolute value difference for any two values in a binary tree.
    * @params root, tree to check
    * @return min absolute value difference as an int
    */
    public int getMinimumDifference(TreeNode root) {
        //empty tree
        if (root == null) {
            return minDiff;
        }
        //traverse left subtree
        if (root.left != null) {
            getMinimumDifference(root.left);
        }
        //process current node
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev);
        }
        prev = root.val;
        //traverse right subtree
        if (root.right != null) {
            getMinimumDifference(root.right);
        }
        return minDiff;
    }
}
