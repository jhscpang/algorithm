//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking

package leetcode.editor.en;

//Java：Generate Parentheses

import java.util.ArrayList;
import java.util.List;

public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            /**
             * 思路：此题也是一种排列组合，但是如P17的一种区别是，P17题可以传递index，然后使用标准的回溯模板即可
             * 本题不能传递index，更贴切的应该算是一种递归，回溯只是递归中特殊的一种
             */
            if (n == 0) {
                return result;
            }
            dfs(new StringBuilder(), 0, 0, n);
            return result;

        }

        private void dfs(StringBuilder curStrBuilder, int left, int right, int n) {
            /**
             * 深度优先遍历的规则是：
             * 1. 左右括号数都等于n时，终止
             * 2. 左 < 右，不可能出现，需要剪枝
             * 3. 产生左分支的时候，只看当前是否还有左括号可以使用；
             * 4. 产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；
             */
            // 终止条件
            if (left == n && right == n) {
                result.add(new StringBuilder(curStrBuilder).toString());
                return;
            }
            // 右枝受左枝限制
            if (left < right) {
                return;
            }
            // 开始递归
            if (left < n) {
                dfs(curStrBuilder.append("("), left + 1, right, n); // 注意，这里如果传引用，就需要回溯
                curStrBuilder.deleteCharAt(curStrBuilder.length() - 1); // 回溯
            }
            if (right < n) {
                dfs(curStrBuilder.append(")"), left, right + 1, n);
                curStrBuilder.deleteCharAt(curStrBuilder.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}