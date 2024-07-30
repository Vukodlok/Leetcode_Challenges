/*
* Leetcode Challenge: Min Stack
*
* Design a stack that supports push, pop, top, and retrieving 
* the minimum element in constant time.
* Implement the MinStack class:
*
* MinStack() initializes the stack object.
* void push(int val) pushes the element val onto the stack.
* void pop() removes the element on the top of the stack.
* int top() gets the top element of the stack.
* int getMin() retrieves the minimum element in the stack.
* You must implement a solution with O(1) time complexity for each function.
*
* 7/30/24
* Mark Robuck
*/

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    /*
    * pushes the element val onto the stack.
    * @params val, integer to push to the stack
    */
    public void push(int val) {
        stack.push(val);
        //if min push to min_stack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    /*
    * removes the element on the top of the stack.
    */
    public void pop() {
        if (!stack.isEmpty()) {
            int popped = stack.pop();
            //if min pop from min_stack
            if (!minStack.isEmpty() && popped == minStack.peek()) {
                minStack.pop();
            }
        }
    }
    
    /*
    * gets the top element of the stack.
    * @return integer on the top of the stack
    */
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }
    
    /*
    * retrieves the minimum element in the stack.
    * @return minimum integer in the stack
    */
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
