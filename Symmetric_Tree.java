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
