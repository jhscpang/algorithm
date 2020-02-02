//Given a set of distinct integers, nums, return all possible subsets (the power
// set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics Array Backtracking Bit Manipulation

package leetcode.editor.en;

//Java：Subsets

import java.util.ArrayList;
import java.util.List;

public class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> lists = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            /**
             * 思路：使用回溯法，本题求子集，因此整个回溯过程都可以算是一种结果
             */
            backtrace(0, nums, new ArrayList<Integer>());
            return lists;
        }

        private void backtrace(int start, int[] nums, List<Integer> list) {
            lists.add(new ArrayList<Integer>(list));
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                backtrace(i + 1, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}