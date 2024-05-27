/*
* Leetcode Challenge: Same Tree
* 
* Given the roots of two binary trees p and q, write a function to check if they are the same or not.
* Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
* 
* 5/3/24
* Mark Robuck
* 

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
    *  Check if two binary trees are equal in values and structure
    * @params p, first tree of the pair to check
    * @params q, second tree of the pair to check
    * @return true if and q are the same values and structure, false otherwise
    */
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
