//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// You are given a target value to search. If found in the array return its inde
//x, otherwise return -1. 
//
// You may assume no duplicate exists in the array. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// Example 1: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1 
// Related Topics Array Binary Search

package leetcode.editor.en;

//Java：Search in Rotated Sorted Array

public class P33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new P33SearchInRotatedSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            /**
             * 思路：此题看到数组有序，并且时间是logN，基本可以判断是要使用二分法
             * 接下来就是如何花样使用二分法的问题，数组旋转后经过二分，一定是至少一半是升序的，利用此规律
             */
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                // 如果找到则直接返回
                if (nums[mid] == target) {
                    return mid;
                }
                // 利用一半有序判断去哪半查找，
                // 这里的<=号要注意，不然在两个元素时会正好相反
                if (nums[low] <= nums[mid]) { // 左边有序
                    // 注意将数组分成[low, mid),(mid, high]两个区间，才不会漏掉元素, 下同
                    if (nums[low] <= target && target < nums[mid]) { // 在左边则去左边找，否则去右边找
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else { // 右边有序
                    if (nums[mid] < target && target <= nums[high]) { // 在右边则去右边找，否则去左边找
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}