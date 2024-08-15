/*
* Leetcode Challenge: Construct Binary Tree from Inorder and Postorder Traversal
*
* Given two integer arrays inorder and postorder where inorder is the 
* inorder traversal of a binary tree and postorder is the postorder 
* traversal of the same tree, construct and return the binary tree.
*
* 8/15/24
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
    * Construct Binary Tree given the inorder, by column, and postprder 
    * list of integers.
    * @params inorder, list of integers as inorder nodes
    * @params postorder, list of integers as postorder nodes
    * @return constructed binary tree of integer values
    */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //empty lists
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        // Helper method for recursion
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        //create root of tree
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        //find the index of the root from inorder
        int inorderIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                inorderIndex = i;
                break;
            }
        }

        //recursively construct left and right tree
        root.left = buildTreeHelper(inorder, inStart, inorderIndex - 1, postorder, postStart, postStart + inorderIndex - inStart - 1);
        root.right = buildTreeHelper(inorder, inorderIndex + 1, inEnd, postorder, postStart + inorderIndex - inStart, postEnd - 1);

        return root;
    }
}
