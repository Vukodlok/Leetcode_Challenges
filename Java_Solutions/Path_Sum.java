/*
* Leetcode Challeneg: Path Sum
*
* Given the root of a binary tree and an integer targetSum, 
* return true if the tree has a root-to-leaf path such that 
* adding up all the values along the path equals targetSum.
* A leaf is a node with no children.
*
* 6/14/24
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
    * Check if a binary tree has a root-to-leaf path with a specific int sum.
    * @params root, the binary tree to be checked
    * @params targetSum, the int sum being checked for
    * return true if a root-to-leaf path exists with a sum of targetSum, false otherwise
    */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //empty tree
        if (root == null) {
            return false;
        }  
        //if we reach a leaf node, check if the current value equals targetSum
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        //recursively check the left and right subtrees with the updated targetSum
        int newTarget = targetSum - root.val;
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }
}
