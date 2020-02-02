//Given a set of candidate numbers (candidates) (without duplicates) and a targe
//t number (target), find all unique combinations in candidates where the candidat
//e numbers sums to target. 
//
// The same repeated number may be chosen from candidates unlimited number of ti
//mes. 
//
// Note: 
//
// 
// All numbers (including target) will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// 
// Related Topics Array Backtracking

package leetcode.editor.en;

//Java：Combination Sum

import java.util.ArrayList;
import java.util.List;

public class P39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        // TO TEST
        int[] candidates = new int[] {2, 3, 6, 7};
        solution.combinationSum(candidates, 7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> lists = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            /**
             * 思路：此类递归回溯的套路，见https://leetcode-cn
             * .com/problems/subsets/solution/xiang-xi-jie-shao-di-gui-hui-su-de-tao-lu-by-reedf/
             */
            if (candidates == null || candidates.length == 0 || target < 0) {
                return lists;
            }
            List<Integer> list = new ArrayList<>();
            process(0, candidates, target, list);
            return lists;
        }

        private void process(int start, int[] candidates, int target, List<Integer> list) {
            //递归的终止条件
            // System.out.println(list); // 打开这个注释能输出递归过程中list的变化
            if (target < 0) {
                return;
            }
            if (target == 0) {
                lists.add(new ArrayList<>(list));
            } else {
                for (int i = start; i < candidates.length; i++) {
                    list.add(candidates[i]); // 尝试加一个新元素
                    // 因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
                    process(i, candidates, target - candidates[i], list);
                    list.remove(list.size() - 1); // 尝试完进行回溯
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}