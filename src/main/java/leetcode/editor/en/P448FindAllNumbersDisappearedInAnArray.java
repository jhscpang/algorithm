//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elemen
//ts appear twice and others appear once. 
//
// Find all the elements of [1, n] inclusive that do not appear in this array. 
//
// Could you do it without extra space and in O(n) runtime? You may assume the r
//eturned list does not count as extra space. 
//
// Example:
// 
//Input:
//[4,3,2,7,8,2,3,1]
//
//Output:
//[5,6]
// 
// Related Topics Array

package leetcode.editor.en;

//Java：Find All Numbers Disappeared in an Array

import java.util.LinkedList;
import java.util.List;

public class P448FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new P448FindAllNumbersDisappearedInAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            /**
             * 思路：使用数组下标法, 遍历数组时，将|nums[i]|-1对应角标的元素设置成负数。
             * 如果nums[i]为负数，说明存在i+1，最后找出不为负的值计算出未出现的数字。
             * 之所以是|nums[i]|-1，是因为数组角标从0开始，而元素范围规定从1开始
             */
            for (int i = 0; i < nums.length; i++) {
                int nextIndex = Math.abs(nums[i]) - 1;
                // 只有在nums[nextIndex]为正数时才设置成负数，负数时不要处理，不然会负负得正
                if (nums[nextIndex] > 0) {
                    nums[nextIndex] *= -1;
                }
            }
            List<Integer> result = new LinkedList<Integer>();
            // 如果nums[i]为负数，说明存在i+1
            for (int i = 1; i <= nums.length; i++) {
                if (nums[i - 1] > 0) {
                    result.add(i);
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}