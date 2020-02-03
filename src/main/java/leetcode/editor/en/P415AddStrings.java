//Given two non-negative integers num1 and num2 represented as string, return th
//e sum of num1 and num2. 
//
// Note:
// 
// The length of both num1 and num2 is < 5100. 
// Both num1 and num2 contains only digits 0-9. 
// Both num1 and num2 does not contain any leading zero. 
// You must not use any built-in BigInteger library or convert the inputs to int
//eger directly. 
// 
// Related Topics String

package leetcode.editor.en;

//Java：Add Strings

public class P415AddStrings {
    public static void main(String[] args) {
        Solution solution = new P415AddStrings().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            /**
             * 思路：利用数学加法原理，控制进位
             */
            StringBuilder res = new StringBuilder("");
            int i = num1.length() - 1; // 记录num1计算的位
            int j = num2.length() - 1; // 记录num2计算的位
            int carry = 0; // 记录进位
            while (i >= 0 || j >= 0) {
                int n1 = i >= 0 ? num1.charAt(i) - '0' : 0; // 位不存在则补0
                int n2 = j >= 0 ? num2.charAt(j) - '0' : 0; // 位不存在则补0
                int tmp = n1 + n2 + carry;
                carry = tmp / 10; // 计算进位
                res.append(tmp % 10); // 保存当前计算的位
                i--;
                j--;
            }
            if (carry == 1) { // 加法最多进位1
                res.append(1);
            }
            return res.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}