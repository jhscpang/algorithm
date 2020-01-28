//
//Given an array of integers and an integer k, you need to find the number of un
//ique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair
// (i, j), where i and j are both numbers in the array and their absolute differen
//ce is k.
// 
//
//
// Example 1: 
// 
//Input: [3, 1, 4, 1, 5], k = 2
//Output: 2
//Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5). Altho
//ugh we have two 1s in the input, we should only return the number of unique pair
//s.
// 
// 
//
// Example 2: 
// 
//Input:[1, 2, 3, 4, 5], k = 1
//Output: 4
//Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) 
//and (4, 5).
// 
// 
//
// Example 3: 
// 
//Input: [1, 3, 1, 5, 4], k = 0
//Output: 1
//Explanation: There is one 0-diff pair in the array, (1, 1).
// 
// 
//
// Note: 
// 
// The pairs (i, j) and (j, i) count as the same pair. 
// The length of the array won't exceed 10,000. 
// All the integers in the given input belong to the range: [-1e7, 1e7]. 
// 
// Related Topics Array Two Pointers

package leetcode.editor.en;

//Java：K-diff Pairs in an Array

import java.util.HashSet;
import java.util.Set;

public class P532KDiffPairsInAnArray {
    public static void main(String[] args) {
        Solution solution = new P532KDiffPairsInAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPairs(int[] nums, int k) {
            /**
             * 思路：这题很像"两数之和"，用HashMap或者HashSet进行元素存储，便于快速查找目标元素是否存在
             */
            if (k < 0 || nums == null || nums.length < 2) {
                return 0;
            }
            Set<Integer> cache = new HashSet<>();
            Set<Integer> diff = new HashSet<>(); // 用较小的那个元素作为重复标准
            for (int i = 0; i < nums.length; i++) {
                if (cache.contains(nums[i] + k)) {
                    diff.add(nums[i]);
                }
                if (cache.contains(nums[i] - k)) {
                    diff.add(nums[i] - k);
                }
                cache.add(nums[i]);
            }
            return diff.size();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}