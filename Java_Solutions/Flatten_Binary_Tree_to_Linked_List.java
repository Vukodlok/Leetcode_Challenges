/*
* Leetcode Challenge: Flatten Binary Tree to Linked List
*
* Given the root of a binary tree, flatten the tree into a "linked list":
*
* The "linked list" should use the same TreeNode class where the 
* right child pointer points to the next node in the list and 
* the left child pointer is always null. The "linked list" should be in 
* the same order as a pre-order traversal of the binary tree.
*
* Do not return anything, modify root in-place instead.
*
* 8/17/24
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
    //pointer for tracking previous node
    private TreeNode prev = null;

    /*
    * Turn a binary tree into a linked list in pre-order traversal.
    * @params root, original tree
    */
    public void flatten(TreeNode root) {
        //base case, empty tree
        if (root == null) {
            return;
        }

            //recursively flatten left and right subtrees
            flatten(root.right);
            flatten(root.left);

            //point right to next and left to none
            root.right = prev;
            root.left = null;
            prev = root;
    }
}
