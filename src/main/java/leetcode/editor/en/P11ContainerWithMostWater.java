//Given n non-negative integers a1, a2, ..., an , where each represents a point 
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis for
//ms a container, such that the container contains the most water. 
//
// Note: You may not slant the container and n is at least 2. 
//
// 
//
// 
//
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In thi
//s case, the max area of water (blue section) the container can contain is 49. 
//
// 
//
// Example: 
//
// 
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49 Related Topics Array Two Pointers

package leetcode.editor.en;

//Java：Container With Most Water

public class P11ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new P11ContainerWithMostWater().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            /**
             * 思路：定义左右指针，依次收敛，记录最大的面积
             */
            if (height == null || height.length == 0) {
                return 0;
            }
            int left = 0; // 左指针
            int right = height.length - 1; // 右指针
            int maxArea = 0;
            while (left < right) {
                int tmpArea = Math.min(height[left], height[right]) * (right - left);
                maxArea = Math.max(maxArea, tmpArea);
                // 收敛左右指针, 如果左边高，就收敛右侧，反之亦然
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return maxArea;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}