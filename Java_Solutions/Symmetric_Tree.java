/*
* Leetcode Challenge: Symmetric Tree
*
* Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
*
* 5/7/24
* Mark Robuck

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
    * Check for symmetry in the branches of a binary tree
    * @params root, binary tree to check
    * @return true if the left and right side of the tree are mirrors of one another, false otherwise
    */
    public boolean isSymmetric(TreeNode root) {
        //check if tree is empty and return true if so
        if (root == null) {
            return true;
        }
        //check for symmetry in branches through a recursive method
        else {
            return mirror(root.left, root.right);
        }
    }
    
    /*
    * Check for null cases and call the function to check for symmetry recursively
    * @params p, one half of the binary tree
    * @params q, the other half of the tree
    * @return true if p and q are mirrors of one another, false otherwise
    */
    public boolean mirror(TreeNode p, TreeNode q) {
        //check if both are empty
        if (p == null && q == null) {
            return true;
        }
        //otherwise check if only one is empty
        else if (p == null || q == null) {
            return false;
        }
        //otherwise recursively check for symmetry
        else {
            return p.val == q.val && mirror(p.left, q.right) && mirror(p.right, q.left);
        }
    }
}
