/*
* Leetcode Challenge: Invert Binary Tree
*
* Given the root of a binary tree, invert the tree, and return its root.
*
* 6/13/24
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
class Solution{
    /*
    * Invert a binary tree.
    * @params root, initial binary tree
    * @return root inverted
    */
    public TreeNode invertTree(TreeNode root) {
        //check for empty tree
        if (root == null) {
            return root;
        }
        //swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
