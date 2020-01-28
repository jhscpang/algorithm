//Given an array nums, write a function to move all 0's to the end of it while m
//aintaining the relative order of the non-zero elements. 
//
// Example: 
//
// 
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0] 
//
// Note: 
//
// 
// You must do this in-place without making a copy of the array. 
// Minimize the total number of operations. 
// Related Topics Array Two Pointers

package leetcode.editor.en;

//Java：Move Zeroes

public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            /**
             * 思路：使用双指针，慢指针记录非0元素即将插入的位置，快指针进行遍历控制
             */
            if (nums == null || nums.length == 0) {
                return;
            }
            int slow = 0;
            for (int fast = 0; fast < nums.length; fast++) {
                if (nums[fast] != 0) {
                    // 非0元素要么在当前位置要么需要移到当前位置之前，将两个位置的值交换就同时完成了移动和赋值操作
                    int tmp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = tmp;
                    slow++;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}