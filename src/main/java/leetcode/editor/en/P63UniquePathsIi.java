//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below). 
//
// The robot can only move either down or right at any point in time. The robot 
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below). 
//
// Now consider if some obstacles are added to the grids. How many unique paths 
//would there be? 
//
// 
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid. 
//
// Note: m and n will be at most 100. 
//
// Example 1: 
//
// 
//Input:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//Output: 2
//Explanation:
//There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
// 
// Related Topics Array Dynamic Programming

package leetcode.editor.en;

//Java：Unique Paths II

public class P63UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new P63UniquePathsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            /**
             * 思路：此题相较于P62多了障碍物的限制，初始化第一行和第一列时，如果遇到障碍物，则后面的点都是到达不了的
             */
            int row = obstacleGrid.length;
            int col = obstacleGrid[0].length;
            // 如果第一个点就是障碍物，则没有解
            if (obstacleGrid[0][0] == 1) {
                return 0;
            }
            obstacleGrid[0][0] = 1; // 设置第一个点的解法数量
            // 填充第一行和第一列的解法数量
            for (int i = 1; i < row; i++) {
                // 如果该位不是障碍，并且前一位不是障碍，则到达该位的解法为1，否则为0
                obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
            }
            for (int i = 1; i < col; i++) {
                obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
            }
            // 填充其他位
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    // 如果该位不是障碍物，则到该位的解法由子问题决定
                    if (obstacleGrid[i][j] == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    } else {
                        // 如果该位是障碍物，则到该位的解法为0
                        obstacleGrid[i][j] = 0;
                    }
                }
            }
            return obstacleGrid[row - 1][col - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}