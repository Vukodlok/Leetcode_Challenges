/*
* Leetcode Challenge: Binary Tree Maximum Path Sum
*
* A path in a binary tree is a sequence of nodes where each pair of 
* adjacent nodes in the sequence has an edge connecting them. A node 
* can only appear in the sequence at most once. Note that the path 
* does not need to pass through the root.
*
* The path sum of a path is the sum of the node's values in the path.
* Given the root of a binary tree, return the maximum path sum of 
* any non-empty path.
*
* 8/22/24
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
    private int maxSum = Integer.MIN_VALUE;

    /*
    * Find the max path sum.
    * @params root, original tree
    * @return max path sum as an integer
    */
    public int maxPathSum(TreeNode root) {

        maxGain(root);
        return maxSum;
    }

        private int maxGain(TreeNode node) {
            //base case
            if (node == null) {
            return 0;
        }
            
            //recursive case
            //calculate through left and right children, ignoring negatives
            int leftGain = Math.max(maxGain(node.left), 0);
            int rightGain = Math.max(maxGain(node.right), 0);

            //calculate passing through current node
            int priceNewPath = node.val + leftGain + rightGain;

            //update max path sum
            maxSum = Math.max(maxSum, priceNewPath);

            return node.val + Math.max(leftGain, rightGain);
        
    }
}
