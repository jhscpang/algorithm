//Given a sorted integer array without duplicates, return the summary of its ran
//ges. 
//
// Example 1: 
//
// 
//Input:  [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]
//Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
// 
//
// Example 2: 
//
// 
//Input:  [0,2,3,4,6,8,9]
//Output: ["0","2->4","6","8->9"]
//Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
// 
// Related Topics Array

package leetcode.editor.en;

//Java：Summary Ranges

import java.util.ArrayList;
import java.util.List;

public class P228SummaryRanges {
    public static void main(String[] args) {
        Solution solution = new P228SummaryRanges().new Solution();
        // TO TEST
        int[] nums = new int[] {0, 1, 2, 4, 5, 7};
        solution.summaryRanges(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            /**
             * 思路：使用双指针，start指针记录起始位置，end指针尝试往后移动寻找结束位置
             */
            List<String> list = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return list;
            }
            int start = 0;
            int end = 0;
            int len = nums.length;
            while (end < len) {
                // 注意这里的边界，以及end试探性的往后移动。如果先移动再判断则不好处理最后的边界
                if ((end + 1) < len && nums[end + 1] == nums[end] + 1) {
                    end++;
                    continue;
                }
                if (end == start) {
                    list.add("" + nums[end]);
                } else {
                    list.add(nums[start] + "->" + nums[end]);
                }
                end++;
                start = end;
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}