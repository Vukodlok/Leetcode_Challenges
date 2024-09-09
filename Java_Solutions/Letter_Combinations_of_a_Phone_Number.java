/*
* Leetcode Challenge: Letter Combinations of a Phone Number
*
* Given a string containing digits from 2-9 inclusive, 
* return all possible letter combinations that the number could represent. 
* Return the answer in any order.
*
* A mapping of digits to letters (just like on the telephone buttons) 
* is given below. Note that 1 does not map to any letters.
*
* 2: abc
* 3: def
* 4: ghi
* 5: jkl
* 6: mno
* 7: pqrs
* 8: tuv
* 9: wxyz
*
* 9/9/24
* Mark Robuck
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
    * Find all possible letter combinations from a phone number.
    * @params digits phone number as strings 2-9
    * @return all possible letter combinations of digits
    */
    public List<String> letterCombinations(String digits) {
        //empty digits
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        //map digits to letter values
        String[] phone = {
            "", "", "abc", "def", "ghi", "jkl", 
            "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> result = new ArrayList<>();
        backtrack(result, digits, phone, 0, new StringBuilder());
        return result;
    }

    //helper backtrack function
    private void backtrack(List<String> result, String digits, String[] phone, int index, StringBuilder path) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        
        String letters = phone[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            path.append(letter);
            backtrack(result, digits, phone, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
