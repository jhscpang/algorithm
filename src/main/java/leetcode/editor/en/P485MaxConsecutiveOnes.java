//Given a binary array, find the maximum number of consecutive 1s in this array.
// 
//
// Example 1: 
// 
//Input: [1,1,0,1,1,1]
//Output: 3
//Explanation: The first two digits or the last three digits are consecutive 1s.
//
//    The maximum number of consecutive 1s is 3.
// 
// 
//
// Note:
// 
// The input array will only contain 0 and 1. 
// The length of input array is a positive integer and will not exceed 10,000 
// 
// Related Topics Array

package leetcode.editor.en;

//Java：Max Consecutive Ones

public class P485MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new P485MaxConsecutiveOnes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            /**
             * 思路：
             * 方法1：可以使用双指针，当end指针遇到0时，计算两个指针间距，与最大间距比较
             * 方法2：用一个计数器 count 记录 1 的数量，另一个计数器 maxCount 记录当前最大的 1 的数量。
             * 当我们遇到 1 时，count 加一。
             * 当我们遇到 0 时，与maxCount比较
             */
            int count = 0;
            int maxCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    // 加一
                    count += 1;
                } else {
                    // 比较
                    maxCount = Math.max(maxCount, count);
                    // 归零
                    count = 0;
                }
            }
            return Math.max(maxCount, count);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}