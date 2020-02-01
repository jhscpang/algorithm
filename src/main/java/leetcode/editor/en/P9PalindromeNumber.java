//Determine whether an integer is a palindrome. An integer is a palindrome when 
//it reads the same backward as forward. 
//
// Example 1: 
//
// 
//Input: 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Follow up: 
//
// Coud you solve it without converting the integer to a string? 
// Related Topics Math

package leetcode.editor.en;

//Java：Palindrome Number

public class P9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            /**
             * 思路：本题主要是处理数学上的高位和低位比较，需要特别注意边界
             */
            if (x < 0) {
                return false;
            }
            if (x == 0) {
                return true;
            }
            // 计算出数组是几位数
            int count = 1;
            int temp = x;
            while (temp >= 10) {
                temp = temp / 10;
                count++;
            }
            // 每次从头和尾对应取数字比较
            int divisor = (int) Math.pow(10, count - 1);
            //从首尾两端开始比较
            while (x != 0) {
                int head = x / divisor;
                int tail = x % 10;
                if (head != tail) {
                    return false;
                }
                x = x % divisor / 10; // 去掉最高位和最低位
                divisor /= 100;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}