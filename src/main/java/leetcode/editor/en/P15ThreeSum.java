//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// Related Topics Array Two Pointers

package leetcode.editor.en;

//Java：3Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            /**
             * 思路：先排序，然后以依次以每个元素为基准，基准之后使用双指针收敛控制和，
             * 如果 nums[i]大于 0，则三数之和必然无法等于0，结束循环
             * 如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
             * 当 sum = 0 时，nums[L] = nums[L+1] 则会导致结果重复，应该跳过，L++
             * 当 sum = 0 时，nums[R] = nums[R−1] 则会导致结果重复，应该跳过，R−−
             */
            List<List<Integer>> ans = new ArrayList();
            if (nums == null || nums.length < 3) {
                return ans;
            }
            int len = nums.length;
            Arrays.sort(nums); // 排序
            for (int i = 0; i < len - 2; i++) {
                if (nums[i] > 0) { // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) { // 去重
                    continue;
                }
                int L = i + 1;
                int R = len - 1;
                while (L < R) { // 双指针依次收敛寻找多对符合条件的值
                    int sum = nums[i] + nums[L] + nums[R];
                    if (sum == 0) { // 和等于目标
                        ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[L + 1]) {
                            L++; // 去重
                        }
                        while (L < R && nums[R] == nums[R - 1]) {
                            R--; // 去重
                        }
                        L++;
                        R--;
                    } else if (sum < 0) { // 和小于目标，需要左边界向右移
                        L++;
                    } else { // 和大于目标，需要右边界向左移
                        R--;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}