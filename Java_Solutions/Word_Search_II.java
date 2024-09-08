/*
* Leetcode Challenge: Word Search II
*
* Given an m x n board of characters and a list of strings words, 
* return all words on the board.
*
* Each word must be constructed from letters of sequentially adjacent cells,
* where adjacent cells are horizontally or vertically neighboring. 
* The same letter cell may not be used more than once in a word.
*
* 9/8/24
* Mark Robuck
*/
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null;
}


public class Solution {
    /*
    * Find all words in a list given a word search board.
    * @params board, given word search board
    * @params words, list of strings representing valid words
    * @return list of all strings found in board from words
    */
    public List<String> findWords(char[][] board, String[] words) {
        //build a tree from word list, words
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }

        //perform depth first search on board
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        
        return result;
    }

        //depth first search
        private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
            char c = board[i][j];
            if (c == '#' || node.children[c - 'a'] == null) return;
            
            node = node.children[c - 'a'];
            if (node.word != null) {
                result.add(node.word);
                //avoid duplicate words
                node.word = null;
            }

        //mark cells as visited
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);
        //reset the cell after search
        board[i][j] = c;  
    }
}
