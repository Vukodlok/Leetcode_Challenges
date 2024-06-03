/*
* Leetcode Challenge: Longest Common Prefix
*
* Write a function to find the longest common prefix string amongst an array of strings.
* If there is no common prefix, return an empty string "".
*
* 6/3/24
* Mark Robuck
*/
class Solution {
    /*
    * Find the longest common prefix in a list of strings.
    * @params strs, list of strings to be compared
    * @return, most common prefix, or empty string if none exist
    */
    public String longestCommonPrefix(String[] strs) {
        //check for empty list
        if (strs.length == 0) {
            return "";
        }
        String common = strs[0];
        //iterate through list of strings
        for (int i = 1; i < strs.length; i++){
        //update common to the smallest prefix by remove the last letter each iteration
            while (!strs[i].startsWith(common)){
                common = common.substring(0, common.length() -1);
                //if reduced to an empty string
                if (common.isEmpty()) {
                    return "";
                }
            }
        }
        return common;
    }
}
