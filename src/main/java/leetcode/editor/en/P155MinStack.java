//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time. 
//
// 
// push(x) -- Push element x onto stack. 
// pop() -- Removes the element on top of the stack. 
// top() -- Get the top element. 
// getMin() -- Retrieve the minimum element in the stack. 
// 
//
// 
//
// Example: 
//
// 
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> Returns -3.
//minStack.pop();
//minStack.top();      --> Returns 0.
//minStack.getMin();   --> Returns -2.
// 
//
// 
// Related Topics Stack Design

package leetcode.editor.en;

//Java：Min Stack

import java.util.Stack;

public class P155MinStack {
    public static void main(String[] args) {
        MinStack solution = new P155MinStack().new MinStack();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        /**
         * 使用一个辅助栈记录最小值，和数据栈同步操作
         * 1. 当数据栈压栈时，如果比辅助栈栈顶元素大，则辅助栈再次压入栈顶本身，负责辅助栈压入新元素
         * 2. 当数据栈弹栈时，数据栈和辅助栈同步弹栈
         */
        Stack<Integer> stack; // 数据栈
        Stack<Integer> helpStack; // 辅助栈

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            helpStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            // 辅助栈永远压入最小的元素
            if (helpStack.isEmpty() || x < helpStack.peek()) {
                helpStack.push(x);
            } else {
                helpStack.push(helpStack.peek());
            }
        }

        public void pop() {
            // 同步弹栈
            stack.pop();
            helpStack.pop();

        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return helpStack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}