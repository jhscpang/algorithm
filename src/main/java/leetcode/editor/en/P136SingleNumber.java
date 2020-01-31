//Given a non-empty array of integers, every element appears twice except for on
//e. Find that single one. 
//
// Note: 
//
// Your algorithm should have a linear runtime complexity. Could you implement i
//t without using extra memory? 
//
// Example 1: 
//
// 
//Input: [2,2,1]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,1,2,1,2]
//Output: 4
// 
// Related Topics Hash Table Bit Manipulation

package leetcode.editor.en;

//Java：Single Number

public class P136SingleNumber {
    public static void main(String[] args) {
        Solution solution = new P136SingleNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            /**
             * 思路：利用位运算的异或，相同数字异或等于0，任何数与0异或等于其本身
             */
            int tmp = 0;
            for (int i = 0; i < nums.length; i++) {
                tmp ^= nums[i];
            }
            return tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}