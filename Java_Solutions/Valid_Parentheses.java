/*
* Leetcode Challenge: Valid Parentheses
*
* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
* determine if the input string is valid.
* An input string is valid if:
* Open brackets must be closed by the same type of brackets.
* Open brackets must be closed in the correct order.
* Every close bracket has a corresponding open bracket of the same type.
*
* 6/10/24
* Mark Robuck
*/
import java.util.Stack;

class Solution {
    /*
    * Determine if all paentheses have been closed in order.
    * @params s, string containing parentheses to be tested
    * @return true if all parentheses are closed, false otherwise
    */
    public boolean isValid(String s) {
        //create stack for matching pairs
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            //if opening parenthesis, push onto stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            //if closing parenthesis
            else {
                //if empty stack, return false
                if (stack.isEmpty()) {
                    return false;
                }
                //pop top element from stack
                char top = stack.pop();
                //check if top element matches current closing parenthesis
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        //if stack is empty, all parentheses were matched correctly
        return stack.isEmpty();
    }
}
