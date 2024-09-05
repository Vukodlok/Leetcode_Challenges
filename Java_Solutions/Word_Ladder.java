/*
* Leetcode Challenge: Word Ladder
*
* A transformation sequence from word beginWord to word endWord using 
* a dictionary wordList is a sequence of words 
* beginWord -> s1 -> s2 -> ... -> sk such that:
*
* Every adjacent pair of words differs by a single letter.
* Every si for 1 <= i <= k is in wordList. Note that beginWord 
* does not need to be in wordList.
* sk == endWord
*
* Given two words, beginWord and endWord, and a dictionary wordList, 
* return the number of words in the shortest transformation sequence 
* from beginWord to endWord, or 0 if no such sequence exists.
*
* 9/5/24
* Mark Robuck
*/
import java.util.*;

class Solution {
    /*
    * Find the minimum number of single letter transformations needed to change one word to another given a dictionary of valid changes.
    * @params beginWord, starting string
    * @params endWord, ending string
    * @params wordList, list of valid string transformations
    * @return minimum number of valid transformations needed to get from beginWord to endWord
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //endWord not in the valid list wordList
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        //bidirectional BFS sets
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        startSet.add(beginWord);
        endSet.add(endWord);
        int steps = 1;

        //BFS loop
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            //work from the smaller set to reduce the search space
            if (startSet.size() > endSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();
            for (String word : startSet) {
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    char originalChar = wordArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[i] = c;
                        String nextWord = new String(wordArray);

                        //if the word is in the opposite set, the transformation is complete
                        if (endSet.contains(nextWord)) {
                            return steps + 1;
                        }

                        //if the next word is in the word list and not visited, add it to the next level
                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            nextSet.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                    //restore original character
                    wordArray[i] = originalChar;
                }
            }

            startSet = nextSet;
            steps++;
        }
        
        //no valid transformation found
        return 0;  
    }
}

/* 
* The first implementation worked but took too long on submission.  To solve 
* this the code was changed to a bidirectional BFS, starting beginWord and 
* endWord at the same time and meeting in the middle.
*/
