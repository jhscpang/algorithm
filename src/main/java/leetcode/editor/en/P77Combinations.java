//Given two integers n and k, return all possible combinations of k numbers out 
//of 1 ... n. 
//
// Example: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
// Related Topics Backtracking

package leetcode.editor.en;

//Java：Combinations

import java.util.ArrayList;
import java.util.List;

public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：此类还是回溯问题，与P39很类似，参考着看
         */
        List<List<Integer>> lists = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            // 异常属于判断
            if (n <= 0 || k <= 0 || n < k) {
                return lists;
            }
            List<Integer> list = new ArrayList<>();
            generateCombinations(1, n, k, list);// 从1开始递归和回溯
            return lists;
        }

        private void generateCombinations(int start, int n, int k, List<Integer> list) {
            // 递归终止条件
            if (list.size() == k) {
                lists.add(new ArrayList<Integer>(list));
                return;
            }
            // 注意： 这里一个剪枝的概念，i <= n的话，会把一些无法组成集合的数据计算以便，可以通过i实际的上限进行剪枝
            // max(i) + 接下来要选择的元素个数 - 1 = n, 其中接下来要选择的元素个数为 k - list.size()
            // 整理得到：max(i) = n - (k - list.size()) + 1
            for (int i = start; i <= n - (k - list.size()) + 1; i++) {
                list.add(i); // 尝试添加
                generateCombinations(i + 1, n, k, list); // 递归
                list.remove(list.size() - 1); // 回溯
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}