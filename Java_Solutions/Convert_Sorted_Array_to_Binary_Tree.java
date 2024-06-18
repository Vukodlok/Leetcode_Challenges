/*
* Leetcode Challenge: Convert Sorted Array to Binary Search Tree
*
* Given an integer array nums where the elements are sorted in ascending order, 
* convert it to a height-balanced binary search tree.
* A height-balanced binary tree is a binary tree in which the depth of the 
* two subtrees of every node never differs by more than one.
*
* 6/18/24
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
    * Convert a sorted array into a binary tree.
    * @params nums, integer list to be turned into a tree
    * @return height-balanced binary tree made from nums
    */
    public TreeNode sortedArrayToBST(int[] nums) {
        //if list is empty
        if (nums.length == 0) {
            return null;
        }
        //call the helper method for using recursion
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }
    /*
    * Use recursion to build a binary tree.
    * @params nums, integer list to be turned into a tree
    * @params left, int to track the left index of the subarray
    * @params right, int to track the right index of the subarray
    * @return height-balanced binary tree made from nums
    */
    private TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        //build the tree from the middle, expanding left and right
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, right);
        
        return root;
    }
}
