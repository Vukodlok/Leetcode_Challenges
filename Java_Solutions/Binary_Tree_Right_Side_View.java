/*
* Leetcode Challenge: Binary Tree Right Side View
*
* Given the root of a binary tree, imagine yourself standing on the 
* right side of it, return the values of the nodes you can see ordered 
* from top to bottom.
*
* 8/23/24
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
    * Return the "right" side of the tree.
    * @params root, original tree
    * @return list of integers of the right side of the tree
    */
    public List<Integer> rightSideView(TreeNode root) {
        //empty tree
        List<Integer> rightSide = new ArrayList<>();
        if (root == null) {
            return rightSide;
        }

        //breadth-first search to traverse tree level by level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.poll();

                //if the last node in a level add to right list
                if (i == levelLength - 1) {
                    rightSide.add(node.val);
                }

                //add child node to queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return rightSide;
    }
}
