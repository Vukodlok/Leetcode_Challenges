/*
* Leetcode Challenge: Validate Binary Search Tree
*
* Given the root of a binary tree, determine if it is a valid 
* binary search tree (BST).
*
* A valid BST is defined as follows:
* The left subtree of a node contains only nodes with keys less 
* than the node's key.
* The right subtree of a node contains only nodes with keys greater 
* than the node's key.
* Both the left and right subtrees must also be binary search trees.
*
* 8/27/24
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
    * Determine if a binary tree is a valid binary search tree.
    * @params root, original tree
    * @return true if a valid BST, false otherwise
    */
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long low, long high) {
            //an empty tree is a valid BST
            if (node == null) {
            return true;
        }
            
            //current node value must be within the range of low and high
            if (node.val <= low || node.val >= high) {
            return false;
        }
            
            //recursively validate left and right subtrees with updated limits
            return validate(node.left, low, node.val) && 
               validate(node.right, node.val, high);
    }
}
