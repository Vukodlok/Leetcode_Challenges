/*
* Leetcode Challenge: Lowest Common Ancestor of a Binary Tree
*
* Given a binary tree, find the lowest common ancestor (LCA) of 
* two given nodes in the tree.
*
* According to the definition of LCA on Wikipedia: “The lowest common 
* ancestor is defined between two nodes p and q as the lowest node 
* in T that has both p and q as descendants (where we allow a node 
* to be a descendant of itself).”
*
* 8/20/24
* Mark Robuck
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    /*
    * Find the lowest common ancestor in a binary tree.
    * @params root, original tree
    * @params p, first of nodes to determine ancestor from
    * @params q, second of nodes to determine ancestor from
    * @return LCA node
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //base case: if root is None, or root is one of p or q
        if (root == null || root == p || root == q) {
            return root;
        }
        
        //recursively search for p and q in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //if p and q are found in different subtrees, root is their LCA
        if (left != null && right != null) {
            return root;
        }
        
        //otherwise, LCA is in that subtree
        return left != null ? left : right; 
    }
}
