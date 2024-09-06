/*
* Leetcode Challenge: Implement Trie (Prefix Tree)
*
* A trie (pronounced as "try") or prefix tree is a tree data structure 
* used to efficiently store and retrieve keys in a dataset of strings. 
* There are various applications of this data structure, such as 
* autocomplete and spellchecker.
* 
* Implement the Trie class:
*
* Trie() Initializes the trie object.
* void insert(String word) Inserts the string word into the trie.
* boolean search(String word) Returns true if the string word is in 
* the trie (i.e., was inserted before), and false otherwise.
* boolean startsWith(String prefix) Returns true if there is a 
* previously inserted string word that has the prefix prefix, and 
* false otherwise.
*
* 9/6/24
* Mark Robuck
*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class TrieNode {
    public TrieNode[] children;
    public boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /*
    * insert a value into the trie if not present
    * @params word, string to be inserted
    */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    /*
    * search for a string value in the existing Trie
    * @params word, string to be searched for
    * @return true if the string exists in trie, flase otherwise
    */
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }
    /*
    * search for a string in trie that begins with the given substring
    * @params prefix, substring to be searched for
    * @return true if any string in trie starts with prefix, false otherwise
    */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}
