/*
* Leetcode Challenge: Evaluate Reverse Polish Notation
*
* You are given an array of strings tokens that represents 
* an arithmetic expression in a Reverse Polish Notation.
* Evaluate the expression. Return an integer that represents 
* the value of the expression.
*
* Note that:
* The valid operators are '+', '-', '*', and '/'.
* Each operand may be an integer or another expression.
* The division between two integers always truncates toward zero.
* There will not be any division by zero.
* The input represents a valid arithmetic expression in a 
* reverse polish notation. The answer and all the intermediate 
* calculations can be represented in a 32-bit integer.
*
* 7/31/24
* Mark Robuck
*/
import java.util.Stack;

class Solution{
    /*
    * Evaluate an expression in reverse polish notation using a stack.
    * @params tokens, expression in reverse polish notation
    * @return value of the expression represented by tokens
    */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens){
            //look for math operation
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                //pop previous two elements
                int b = stack.pop();
                int a = stack.pop();
                //perform the operation and push result to the stack
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } else {
            //if number
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
