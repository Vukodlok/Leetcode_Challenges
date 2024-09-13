/*
* Leetcode Challenge: Generate Parentheses
*
* Given n pairs of parentheses, write a function to generate all 
* combinations of well-formed parentheses.
*
* 9/13/24
* Mark Robuck
*/
import java.util.ArrayList;
import java.util.List;

class Solution{
    /*
    * Find all possible combinations of properly formatted parentheses.
    * @params n, number of pairs of parentheses
    * @return all possible combinations of formatted parentheses
    */
    public List<String> generateParenthesis(int n) {
        //start backtracking from an empty string
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
        
        //helper function for backtracking
        private void backtrack(List<String> result, String current, int open, int close, int max) {
            //base case: valid combination
            if (current.length() == max * 2) {
                result.add(current);
            return;
            }
            
            //add an open parenthesis if we haven't reached the limit
            if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
            
            //add a closing parenthesis if there are open parentheses to close
            if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
