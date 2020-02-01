//You are climbing a stair case. It takes n steps to reach to the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top? 
//
// Note: Given n will be a positive integer. 
//
// Example 1: 
//
// 
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
// Related Topics Dynamic Programming

package leetcode.editor.en;

//Java：Climbing Stairs

public class P70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            /**
             * 思路：
             * 解法一：使用递归会超时，因此使用循环替代
             */
            // if (n <= 0) {
            //     return 0;
            // }
            // if (n == 1) {
            //     return 1;
            // }
            // if (n == 2) {
            //     return 2;
            // }
            // return climbStairs(n - 1) + climbStairs(n - 2);
            /**
             * 解法二：使用迭代
             */
            if (n <= 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int num1 = 1;
            int num2 = 2;
            int result = 0;
            for (int i = 3; i <= n; i++) {
                result = num1 + num2;
                num1 = num2;
                num2 = result;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}