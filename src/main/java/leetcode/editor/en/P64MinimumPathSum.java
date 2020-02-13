//Given a m x n grid filled with non-negative numbers, find a path from top left
// to bottom right which minimizes the sum of all numbers along its path. 
//
// Note: You can only move either down or right at any point in time. 
//
// Example: 
//
// 
//Input:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//Output: 7
//Explanation: Because the path 1→3→1→1→1 minimizes the sum.
// 
// Related Topics Array Dynamic Programming

package leetcode.editor.en;

//Java：Minimum Path Sum

public class P64MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new P64MinimumPathSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            /**
             * 思路：使用从下向上的动态规划设置权值，边界上只有一种走法，
             * 非边界有两种走法，这时取两种走法中最小的那个
             */
            int[][] dp = new int[grid.length][grid[0].length];
            for (int i = grid.length - 1; i >= 0; i--) { // 控制行
                for (int j = grid[0].length - 1; j >= 0; j--) { // 控制列
                    if (i == grid.length - 1 && j != grid[0].length - 1) { // 最底行
                        dp[i][j] = grid[i][j] + dp[i][j + 1];
                    } else if (j == grid[0].length - 1 && i != grid.length - 1) { // 最右列
                        dp[i][j] = grid[i][j] + dp[i + 1][j];
                    } else if (j != grid[0].length - 1 && i != grid.length - 1) { // 中间行列
                        dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                    } else { // 同时在最底行和最右列，也就是右下角初始的点
                        dp[i][j] = grid[i][j];
                    }
                }
            }
            return dp[0][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}