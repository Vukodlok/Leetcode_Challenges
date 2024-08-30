/*
* Leetcode Challenge: Clone Graph
*
* Given a reference of a node in a connected undirected graph.
* Return a deep copy (clone) of the graph.
*
* Each node in the graph contains a value (int) and a list (List[Node]) of 
* its neighbors.
*
* class Node {
*     public int val;
*     public List<Node> neighbors;
* }
* 
* Test case format:
*
* For simplicity, each node's value is the same as the node's 
* index (1-indexed). For example, the first node with val == 1, 
* the second node with val == 2, and so on. The graph is represented 
* in the test case using an adjacency list.
*
* An adjacency list is a collection of unordered lists used to represent 
* a finite graph. Each list describes the set of neighbors of a node in 
* the graph.
*
* The given node will always be the first node with val = 1. You must 
* return the copy of the given node as a reference to the cloned graph.
*
* 8/30/24
* Mark Robuck
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.*;

class Solution {
    /*
    * Clone a graph data structure.
    * @params node, original graph
    * @return cloned copy of original graph
    */
    public Node cloneGraph(Node node) {
        //empty graph
        if (node == null) {
            return null;
        }

        Map<Node, Node> clonedNodes = new HashMap<>();

        //dfs helper function
        return dfs(node, clonedNodes);
    }


        private Node dfs(Node node, Map<Node, Node> clonedNodes) {
            if (clonedNodes.containsKey(node)) {
                return clonedNodes.get(node);
        }

            //clone the node
            Node clone = new Node(node.val);
            clonedNodes.put(node, clone);

            //recursively clone neighbors
            for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, clonedNodes));
        }

        return clone;
    }
}
