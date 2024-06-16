/*
* Leetcode Challenge: Average of Levels in Binary Tree
*
* Given the root of a binary tree, return the average value of the nodes on each level 
* in the form of an array. Answers within 10^-5 of the actual answer will be accepted.
*
* 6/16/24
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
    /**
    * Average the node values of each level of a binary tree.
    * @params root, given tree to find averages for
    * @ return average of each level as a list
    */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        //if tree is empty
        if (root == null) {
            return averages;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;
            //sum single level in the tree
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                //add next level of nodes to the next queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //calculate average for the level and append to the list
            averages.add(levelSum / levelSize);
            }
        
        return averages;
    }
}
