//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// If the target is not found in the array, return [-1, -1]. 
//
// Example 1: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4] 
//
// Example 2: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1] 
// Related Topics Array Binary Search

package leetcode.editor.en;

//Java：Find First and Last Position of Element in Sorted Array

public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            /**
             * 思路：二分查找思路简单，但是细节很难弄，这里记录一个边界相对统一的方法
             * 多看，多看，多看！！！
             */
            int[] result = new int[2];
            result[0] = findFirst(nums, target);
            result[1] = findLast(nums, target);
            return result;
        }

        private int findFirst(int[] nums, int target) {
            int idx = -1;
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] >= target) { // 右区间不断向左
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                if (nums[mid] == target) { // 这步不能少
                    idx = mid;
                }
            }
            return idx;
        }

        private int findLast(int[] nums, int target) {
            int idx = -1;
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] <= target) { // 左区间不断向右
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                if (nums[mid] == target) { // 这步不能少
                    idx = mid;
                }
            }
            return idx;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}