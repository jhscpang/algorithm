//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// Note that an empty string is also considered valid. 
//
// Example 1: 
//
// 
//Input: "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: "{[]}"
//Output: true
// 
// Related Topics String Stack

package leetcode.editor.en;

//Java：Valid Parentheses

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            /**
             * 思路：用Map存括号的对应关系，遇到左括号则压栈，遇到右括号则弹栈，进行匹配检查
             */
            if (s == null || s.length() == 0) {
                return true;
            }
            Map<Character, Character> map = new HashMap<Character, Character>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (map.containsValue(c)) {
                    // 遇到左括号则入栈
                    stack.push(c);
                } else {
                    // 遇到右括号则进行比较
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character tmp = stack.pop();
                    if (!tmp.equals(map.get(c))) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}