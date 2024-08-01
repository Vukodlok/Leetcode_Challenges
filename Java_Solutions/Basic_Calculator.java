/*
* Leetcode Challenge: Basic Calculator
*
* Given a string s representing a valid expression, implement a basic 
* calculator to evaluate it, and return the result of the evaluation.
* Note: You are not allowed to use any built-in function which evaluates 
* strings as mathematical expressions, such as eval().
*
* 8/1/24
* Mark Robuck
*/
import java.util.Stack;

class Solution{
    /*
    * Evaluate a string as a mathematical expression with + and -.
    * @params s, string to evaluate as a math expression
    * @return answer to s as an integer
    */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        int result = 0;
        //sign for positive or negative
        int sign = 1;

        //loop through array and perform operations
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //build number
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            //add current to result and set values
            } else if (ch == '+') {
                result += sign * currentNumber;
                currentNumber = 0;
                sign = 1;
            //subtract current to result and set values
            } else if (ch == '-') {
                result += sign * currentNumber;
                currentNumber = 0;
                sign = -1;
            //push sign and result to stack and set values
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            //finish current sub-expression
            } else if (ch == ')') {
                result += sign * currentNumber;
                currentNumber = 0;
                //pop sign before parenthesis
                result *= stack.pop();
                //pop previous result
                result += stack.pop();
            }
        }
        result += sign * currentNumber;
        return result;      
    }
}
