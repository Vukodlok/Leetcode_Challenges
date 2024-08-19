/*
* Leetcode Challenge: Sum Root to Leaf Numbers
*
* You are given the root of a binary tree containing digits from 0 to 9 only.
* Each root-to-leaf path in the tree represents a number.
* For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
* Return the total sum of all root-to-leaf numbers. Test cases are generated 
* so that the answer will fit in a 32-bit integer.
* A leaf node is a node with no children.
*
* 8/19/24
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
    * Find the number represented in root-to-leaf path of a binary tree and sum all values.
    * @params root, original tree root
    * @return sum of all root-to-leaf values
    */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    //perform a depth-first-search to traverse the tree
    private int dfs(TreeNode node, int currentNumber) {
        //base case
        if (node == null) {
        return 0;
        }

        //update current number by appending node value
        currentNumber = currentNumber * 10 + node.val;

        //if end of path return current number
        if (node.left == null && node.right == null) {
        return currentNumber;
        }

        //continue process for left and right children
        int leftSum = dfs(node.left, currentNumber);
        int rightSum = dfs(node.right, currentNumber);

        return leftSum + rightSum;
    }
}
