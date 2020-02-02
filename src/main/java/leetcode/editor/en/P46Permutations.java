//Given a collection of distinct integers, return all possible permutations. 
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics Backtracking

package leetcode.editor.en;

//Java：Permutations

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> lists = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            /**
             * 思路：这类问题依然是回溯法，不断与后面交换
             */
            List<Integer> numList = new ArrayList<>();
            // 构造List，便于后面使用集合工具类
            for (int num : nums) {
                numList.add(num);
            }
            backtrace(0, numList);
            return lists;
        }

        private void backtrace(int start, List<Integer> nums) {
            // 递归终止条件
            if (start == nums.size()) {
                lists.add(new ArrayList<Integer>(nums));
                return;
            }
            for (int i = start; i < nums.size(); i++) {
                Collections.swap(nums, start, i); // 尝试交换
                backtrace(start + 1, nums); // 递归
                Collections.swap(nums, start, i); // 回溯
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}