/*
* Leetcode Challenge: Design Add and Search Words Data Structure
*
* Design a data structure that supports adding new words and finding if 
* a string matches any previously added string.
* 
* Implement the WordDictionary class:
* 
* WordDictionary() Initializes the object.
* void addWord(word) Adds word to the data structure, it can be matched later.
* bool search(word) Returns true if there is any string in the data 
* structure that matches word or false otherwise. word may contain 
* dots '.' where dots can be matched with any letter.
*
* 9/7/24
* Mark Robuck
*/

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class WordDictionary {

    private TrieNode root;

    //create a data structure of words
    public WordDictionary() {
        root = new TrieNode();
    }

    /*
    * Add a word to the data structure
    * @params words, word to be added to the data structure
    */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    /*
    * Search for a word in the data structure using DFS approach
    * @params word, word to search the data structure for
    * @return true if the word is in the data, false otherwise
    */
    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }

    private boolean dfs(char[] word, int i, TrieNode node) {
        if (i == word.length) {
            return node.isEndOfWord;
        }
        char c = word[i];
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, i + 1, child)) {
                    return true;
                }
            }
        } else {
            int index = c - 'a';
            if (node.children[index] != null && dfs(word, i + 1, node.children[index])) {
                return true;
            }
        }
        return false;
    }
}
