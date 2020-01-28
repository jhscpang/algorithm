//Given a non-empty array of digits representing a non-negative integer, plus on
//e to the integer. 
//
// The digits are stored such that the most significant digit is at the head of 
//the list, and each element in the array contain a single digit. 
//
// You may assume the integer does not contain any leading zero, except the numb
//er 0 itself. 
//
// Example 1: 
//
// 
//Input: [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
// 
//
// Example 2: 
//
// 
//Input: [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
// Related Topics Array

package leetcode.editor.en;

//Java：Plus One

public class P66PlusOne {
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
        // TO TEST
        int[] digits = new int[] {1, 2, 3}; // expext 124
        printArray(solution.plusOne(digits));
        digits = new int[] {1, 2, 9}; // expext 130
        printArray(solution.plusOne(digits));
        digits = new int[] {9, 9, 9}; // expext 1000
        printArray(solution.plusOne(digits));
    }

    private static String printArray(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
        }
        String s = stringBuilder.toString();
        System.out.println(s);
        return s;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            /**
             * 思路：遇到9则进位，否则不进位，如果最高位进位后是0，应该再升一位
             */
            int length = digits.length;
            for (int i = length - 1; i >= 0; i--) {
                // 不产生进位情况，直接返回
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }
                // 产生了进位
                digits[i] = 0;
            }
            // 为进位多出了一位数进行处理， 走到这里一定是因为产生了进位一位数
            int[] newDigits = new int[length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}