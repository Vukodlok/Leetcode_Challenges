/*
* Leetcode Challenge: Find the Index of the First Occurence in a String
*
* Given two strings needle and haystack, return the index of the first occurrence of 
* needle in haystack, or -1 if needle is not part of haystack.
* 
* 5/29/24
* Mark Robuck
*/
class Solution {
    /*
    * find the index of the first time needle appears in haystack
    * @params haystack, string to be searched
    * @params needle, string being searched for
    * @return, index of the first occurrence of needle in haystack as an int
    */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
