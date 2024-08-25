/*
* Leetcode Challenge: Binary Tree Zigzag Level Order Traversal
*
* Given the root of a binary tree, return the zigzag level order traversal 
* of its nodes' values. (i.e., from left to right, then right to left for 
* the next level and alternate between).
*
* 8/25/24
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
import java.util.*;

class Solution {
    /*
    * Return nodes of binary tree in zagzag level order, left-right-left-etc.
    * @params root, original tree
    * @return list of integer node values in zigzag level order
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //empty tree
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //initialize direction
        boolean leftToRight = true;
        
        while (!queue.isEmpty()) {
            //number of nodes at the current level
            int levelSize = queue.size();
            LinkedList<Integer> levelNodes = new LinkedList<>();
            
            //process each node in the current level
            for (int i = 0; i < levelSize; i++) {
                //get the next node from the queue
                TreeNode node = queue.poll();
                
                //append node value depending on the current direction
                if (leftToRight) {
                    levelNodes.addLast(node.val);
                } else {
                    levelNodes.addFirst(node.val);
                }

                //add children to queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            //flip direction after processing
            leftToRight = !leftToRight;
            result.add(levelNodes);
        }
        
        return result;
        
    }
}
