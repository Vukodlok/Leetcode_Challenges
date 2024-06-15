/*
* Leetcode Challenge: Count Complete Tree Nodes
*
* Given the root of a complete binary tree, return the number of the nodes in the tree.
* According to Wikipedia, every level, except possibly the last, is completely filled 
* in a complete binary tree, and all nodes in the last level are as far left as possible. 
* It can have between 1 and 2h nodes inclusive at the last level h.
* Design an algorithm that runs in less than O(n) time complexity.
*
* 6/15/24
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
    * Count the number of nodes in a binary tree.
    * @params root, binary tree to count
    * @return, number of nodes in a tree
    */
    public int countNodes(TreeNode root) {
        //empty tree
        if (root == null) {
            return 0;
        }
        //count existing nodes recursively, plus one for root node
        return this.countNodes(root.left) + this.countNodes(root.right) + 1;
    }
}
