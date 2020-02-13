//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find 
//the one that is missing from the array. 
//
// Example 1: 
//
// 
//Input: [3,0,1]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [9,6,4,2,3,5,7,0,1]
//Output: 8
// 
//
// Note: 
//Your algorithm should run in linear runtime complexity. Could you implement it
// using only constant extra space complexity? Related Topics Array Math Bit Manip
//ulation

package leetcode.editor.en;

//Java：Missing Number

public class P268MissingNumber {
    public static void main(String[] args) {
        Solution solution = new P268MissingNumber().new Solution();
        // TO TEST
        int[] nums = new int[] {1, 2, 3, 5, 6};
        System.out.println(solution.missingNumber(nums));
        nums = new int[] {1, 2, 3, 4};
        System.out.println(solution.missingNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            /**
             * 思路：本次有很多思路，比如：
             * 1. 所有数字求和减去数字的和
             * 2. 求异或和
             */
            int missing = nums.length;
            for (int i = 0; i < nums.length; i++) {
                missing ^= i ^ nums[i];
            }
            return missing;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}