//Given a positive integer n, generate a square matrix filled with elements from
// 1 to n2 in spiral order. 
//
// Example: 
//
// 
//Input: 3
//Output:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
// 
// Related Topics Array

package leetcode.editor.en;

//Java：Spiral Matrix II

public class P59SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            /**
             * 思路：和P54类似，设定上下左右边界，然后依次打印，
             * 用start<=end进行边界判断, 而不是l < r || t < b作为迭代条件，是为了解决当n为奇数时，矩阵中心数字无法在迭代过程中被填充的问题。
             */
            int top = 0; // 上边界
            int down = n - 1; // 下边界
            int left = 0; // 左边界
            int right = n - 1; // 右边界
            int[][] matrix = new int[n][n];
            int start = 1;
            int end = n * n;
            while (start <= end) {
                // 先往右走
                for (int i = left; i <= right; i++) {
                    matrix[top][i] = start++;
                }
                top++;
                // 往下走
                for (int i = top; i <= down; i++) {
                    matrix[i][right] = start++;
                }
                right--;
                // 往左走
                for (int i = right; i >= left; i--) {
                    matrix[down][i] = start++;
                }
                down--;
                // 往上走
                for (int i = down; i >= top; i--) {
                    matrix[i][left] = start++;
                }
                left++;
            }
            return matrix;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}