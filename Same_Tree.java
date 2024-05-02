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
    public boolean isSameTree(TreeNode p, TreeNode q) {
       //check if both trees are empty
       if(p == null && q == null) {
        return true;
       }
       //check if only one tree is empty
       else if (p == null || q == null) {
        return false;
       }
       //check if values are different
       else if (p.val != q.val) {
        return false;
       }
       //recursively compare values
       return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
