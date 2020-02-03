//The gray code is a binary numeral system where two successive values differ in
// only one bit. 
//
// Given a non-negative integer n representing the total number of bits in the c
//ode, print the sequence of gray code. A gray code sequence must begin with 0. 
//
// Example 1: 
//
// 
//Input: 2
//Output: [0,1,3,2]
//Explanation:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//
//For a given n, a gray code sequence may not be uniquely defined.
//For example, [0,2,3,1] is also a valid gray code sequence.
//
//00 - 0
//10 - 2
//11 - 3
//01 - 1
// 
//
// Example 2: 
//
// 
//Input: 0
//Output: [0]
//Explanation: We define the gray code sequence to begin with 0.
//             A gray code sequence of n has size = 2n, which for n = 0 the size
// is 20 = 1.
//             Therefore, for n = 0 the gray code sequence is [0].
// 
// Related Topics Backtracking

package leetcode.editor.en;

//Java：Gray Code

import java.util.ArrayList;
import java.util.List;

public class P89GrayCode {
    public static void main(String[] args) {
        Solution solution = new P89GrayCode().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> grayCode(int n) {
            /**
             * 思路：使用动态规划或者说是递归方法，具体看这个题解的解法一：https://leetcode-cn.com/problems/gray-code/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--12/
             * 根据grayCode(n-1)来推导grayCode(n)
             */
            List<Integer> list = new ArrayList<>();
            list.add(0); // 初始化0的时候的初始gray code
            for (int i = 0; i < n; i++) {
                int toAdd = 1 << i; // 将要加的数，使用左移速度比较快
                // 倒序遍历，并且加上一个值添加到结果中, 只有倒序相加才满足格雷码规则
                for (int j = list.size() - 1; j >= 0; j--) {
                    list.add(list.get(j) + toAdd);
                }
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}