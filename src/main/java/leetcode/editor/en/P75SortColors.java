//Given an array with n objects colored red, white or blue, sort them in-place s
//o that objects of the same color are adjacent, with the colors in the order red,
// white and blue. 
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white,
// and blue respectively. 
//
// Note: You are not suppose to use the library's sort function for this problem
//. 
//
// Example: 
//
// 
//Input: [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2] 
//
// Follow up: 
//
// 
// A rather straight forward solution is a two-pass algorithm using counting sor
//t. 
// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite
// array with total number of 0's, then 1's and followed by 2's. 
// Could you come up with a one-pass algorithm using only constant space? 
// 
// Related Topics Array Two Pointers Sort

package leetcode.editor.en;

//Java：Sort Colors

public class P75SortColors {
    public static void main(String[] args) {
        Solution solution = new P75SortColors().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            /**
             * 思路：本题提倡一次遍历，利用双指针，p0指针指向0该插入的位置，p2指针指向2该插入的位置
             * cur指针从左到右遍历
             * 如果cur == 0，则与p0交换，同时p0++，cur++
             * 如果cur == 2，则与p2交换，同时p2--，cur不动，因为从p2换过来的元素需要在下一轮处理
             * 如果cur == 1, 则不需要交换
             */
            if (nums == null || nums.length == 0) {
                return;
            }
            int p0 = 0;
            int p2 = nums.length - 1;
            int cur = 0;
            while (cur <= p2) {
                if (nums[cur] == 0) {
                    swap(nums, cur, p0);
                    cur++;
                    p0++;
                } else if (nums[cur] == 2) {
                    swap(nums, cur, p2);
                    p2--;
                } else {
                    cur++;
                }
            }
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}