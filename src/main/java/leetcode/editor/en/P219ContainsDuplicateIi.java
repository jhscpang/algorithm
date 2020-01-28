//Given an array of integers and an integer k, find out whether there are two di
//stinct indices i and j in the array such that nums[i] = nums[j] and the absolute
// difference between i and j is at most k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1], k = 3
//Output: true
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1,0,1,1], k = 1
//Output: true
// 
//
// 
// Example 3: 
//
// 
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
// 
// 
// 
// 
// Related Topics Array Hash Table

package leetcode.editor.en;

//Java：Contains Duplicate II

import java.util.HashSet;
import java.util.Set;

public class P219ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new P219ContainsDuplicateIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            /**
             * 方法1. 使用HashMap判断是否存在重复元素，并且距离是否在k范围内
             */
            //            Map<Integer, Integer> map = new HashMap<>();
            //            for (int i = 0; i < nums.length; i++) {
            //                if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
            //                    return true;
            //                } else {
            //                    map.put(nums[i], i);
            //                }
            //            }
            //            return false;

            /**
             * 方法2. 使用大小为K的HashSet，判断这个k大小的窗口内是否存在重复元素
             */
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                } else {
                    set.add(nums[i]);
                }
                // 控制窗口大小
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}