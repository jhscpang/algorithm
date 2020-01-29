//Given an integer, write a function to determine if it is a power of two. 
//
// Example 1: 
//
// 
//Input: 1
//Output: true 
//Explanation: 20 = 1
// 
//
// Example 2: 
//
// 
//Input: 16
//Output: true
//Explanation: 24 = 16 
//
// Example 3: 
//
// 
//Input: 218
//Output: false 
// Related Topics Math Bit Manipulation

package leetcode.editor.en;

//Java：Power of Two

public class P231PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new P231PowerOfTwo().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            /**
             * 思路：巧妙利用二进制
             */
            return n <= 0 ? false : (n & (n - 1)) == 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}