//Given a matrix of m x n elements (m rows, n columns), return all elements of t
//he matrix in spiral order. 
//
// Example 1: 
//
// 
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
// 
//Input:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// Related Topics Array

package leetcode.editor.en;

//Java：Spiral Matrix

import java.util.ArrayList;
import java.util.List;

public class P54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            /**
             * 思路：设定上下左右边界，然后依次打印
             */
            List<Integer> list = new ArrayList<>();
            if (matrix == null || matrix.length == 0) {
                return list;
            }
            int top = 0; // 上边界
            int down = matrix.length - 1; // 下边界
            int left = 0; // 左边界
            int right = matrix[0].length - 1; // 右边界
            while (true) {
                // 先往右走
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                if (++top > down) { // 判断是否还可以向下，同时缩小上边界，下同
                    break;
                }
                // 往下走
                for (int i = top; i <= down; i++) {
                    list.add(matrix[i][right]);
                }
                if (--right < left) {
                    break;
                }
                // 往左走
                for (int i = right; i >= left; i--) {
                    list.add(matrix[down][i]);
                }
                if (--down < top) {
                    break;
                }
                // 往上走
                for (int i = down; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                if (++left > right) {
                    break;
                }
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}