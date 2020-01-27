//Given an array of integers, find if the array contains any duplicates. 
//
// Your function should return true if any value appears at least twice in the a
//rray, and it should return false if every element is distinct. 
//
// Example 1: 
//
// 
//Input: [1,2,3,1]
//Output: true 
//
// Example 2: 
//
// 
//Input: [1,2,3,4]
//Output: false 
//
// Example 3: 
//
// 
//Input: [1,1,1,3,3,4,3,2,4,2]
//Output: true 
// Related Topics Array Hash Table

package leetcode.editor.en;

//Java：Contains Duplicate

import java.util.HashMap;

public class P217ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new P217ContainsDuplicate().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            /**
             * 1. 将数组排序，然后比较相邻元素是否相同
             * 2. 使用HashMap
             */
            int n = nums.length;
            HashMap<Integer, Integer> map = new HashMap();
            for (int i = 0; i < n; i++) {
                if (map.containsKey(nums[i])) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}