//Given an array nums of n integers and an integer target, find three integers i
//n nums such that the sum is closest to target. Return the sum of the three integ
//ers. You may assume that each input would have exactly one solution. 
//
// Example: 
//
// 
//Given array nums = [-1, 2, 1, -4], and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
// Related Topics Array Two Pointers

package leetcode.editor.en;

//Java：3Sum Closest

import java.util.Arrays;

public class P16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            /**
             * 思路：与p15题类似，先排序，然后以依次以每个元素为基准，基准之后使用双指针收敛控制和
             * 但是不需要去重，需要一个变量记录最接近的和
             */
            if (nums == null || nums.length < 3) {
                return Integer.MAX_VALUE;
            }
            int len = nums.length;
            Arrays.sort(nums); // 排序
            int ans = nums[0] + nums[1] + nums[2]; // 初始化ans值
            for (int i = 0; i < len - 2; i++) {
                int L = i + 1;
                int R = len - 1;
                while (L < R) {
                    int sum = nums[L] + nums[R] + nums[i];
                    if (Math.abs(target - sum) < Math.abs(target - ans)) { // 记录最接近的和
                        ans = sum;
                    }
                    // 调整左右指针
                    if (sum == target) {
                        return sum;
                    } else if (sum < target) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}