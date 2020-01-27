//Given an array, rotate the array to the right by k steps, where k is non-negat
//ive. 
//
// Example 1: 
//
// 
//Input: [1,2,3,4,5,6,7] and k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: [-1,-100,3,99] and k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// Note: 
//
// 
// Try to come up as many solutions as you can, there are at least 3 different w
//ays to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// Related Topics Array

package leetcode.editor.en;

//Java：Rotate Array

public class P189RotateArray {
    public static void main(String[] args) {
        Solution solution = new P189RotateArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            /**
             * 1. 使用环状替换法，将数组视为一个环，每个元素都往后移动k步，直到全部元素都移动完
             */
//            k = k % nums.length; // 对k取模
//            int count = 0;
//            for (int start = 0; count < nums.length; start++) {
//                int current = start;
//                int prev = nums[start];
//                // 内层循环
//                do {
//                    int next = (current + k) % nums.length;
//                    int temp = nums[next];
//                    nums[next] = prev;
//                    prev = temp;
//                    current = next;
//                    count++; // 记录移动次数，次数与数组大小相同时说明全移动完了
//                } while (start != current);
//            }
            /**
             * 2. 使用旋转数组法
             */
            int len = nums.length;
            k = k % len;
            reverse(nums, 0, len - 1); // 先旋转整体
            reverse(nums, 0, k - 1); // 再旋转局部
            reverse(nums, k, len - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}