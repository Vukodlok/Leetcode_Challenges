/*
* Leetcode Challenge: Binary Tree Level Order Traversal
*
* Given the root of a binary tree, return the level order traversal 
* of its nodes' values. (i.e., from left to right, level by level).
*
* 8/24/24
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
    * Return node values of a binary tree in left to right level order.
    * @params root, original tree
    * @return integer list of node value in left to right level order
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        //empty tree
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            result.add(levelNodes);
        }
        
        return result;
    }
}
