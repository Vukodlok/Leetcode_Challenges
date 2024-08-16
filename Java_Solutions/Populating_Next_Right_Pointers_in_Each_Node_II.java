/*
* Leetcode Challenge: Populating Next Right Pointers in Each Node II
*
* Given a binary tree, populate each next pointer to point to its next 
* right node. If there is no next right node, the next pointer should 
* be set to NULL.
*
* Initially, all next pointers are set to NULL.
*
* 8/16/24
* Mark Robuck
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    /*
    * Set nodes to the right of existing nodes in binary tree.
    * @params root, original tree root
    * @return binary tree with all "right node" pointers set
    */
    public Node connect(Node root) {
        //empty tree
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current != null) {
            //dummy node for handling next connection
            Node dummy = new Node(0);
            Node tail = dummy;

            //traverse nodes at current level
            while (current != null) {
                if (current.left != null) {
                    tail.next = current.left;
                    tail = tail.next;
                }
                if (current.right != null) {
                    tail.next = current.right;
                    tail = tail.next;
                }

            current = current.next;
            }

            //move to next level
            current = dummy.next;
        }

        return root;
        
    }
}
