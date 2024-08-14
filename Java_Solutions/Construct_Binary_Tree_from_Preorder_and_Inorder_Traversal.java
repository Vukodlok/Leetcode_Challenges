/*
* Leetcode Challenge: Construct Binary Tree from Preorder and Inorder Traversal
* 
* Given two integer arrays preorder and inorder where preorder is the 
* preorder traversal of a binary tree and inorder is the inorder traversal 
* of the same tree, construct and return the binary tree.
*
* 8/14/24
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
import java.util.HashMap;

class Solution {
    private HashMap<Integer, Integer> inorderMap;
    private int preorderIndex;
    /*
    * Given the preorder, by row, and inorder, by column, list of integers
    * construct the binary tree.
    * @params preorder, list of integers ordered top to bottom
    * @params inorder, list of integers ordered left to right
    * @return completed binary tree
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //initialize preorder index, build map of inorder values and indices
        preorderIndex = 0;
        inorderMap = new HashMap<>();

        //set HashMap value -> index relationships for inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        //call the recursive helper function
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int inorderStart, int inorderEnd) {
        //base case: if there are no elements to construct the tree
        if (inorderStart > inorderEnd) {
            return null;
        }

        //first element in preorder is root of current tree/subtree
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        //find the index of the root in inorder
        int inorderIndex = inorderMap.get(rootVal);

        //recursively build the left and right subtrees
        root.left = helper(preorder, inorderStart, inorderIndex - 1);
        root.right = helper(preorder, inorderIndex + 1, inorderEnd);

        return root;
    }
}
