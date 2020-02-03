//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below). 
//
// The robot can only move either down or right at any point in time. The robot 
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below). 
//
// How many possible unique paths are there? 
//
// 
//Above is a 7 x 3 grid. How many possible unique paths are there? 
//
// Note: m and n will be at most 100. 
//
// Example 1: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-righ
//t corner:
//1. Right -> Right -> Down
//2. Right -> Down -> Right
//3. Down -> Right -> Right
// 
//
// Example 2: 
//
// 
//Input: m = 7, n = 3
//Output: 28 
// Related Topics Array Dynamic Programming

package leetcode.editor.en;

//Java：Unique Paths

public class P62UniquePaths {
    public static void main(String[] args) {
        Solution solution = new P62UniquePaths().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            /**
             * 思路：此题是动态规划题，动态规划和回溯法是有点区别的
             * 动态规划法关键是找到动态转化方程，也就非常适用递归来具体实现
             * 回溯法关键是状态回退，这是二者的区别
             * 本题的这个题解的动态规划法解释的很好：https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-by-powcai-2/
             */
            int[][] dp = new int[m][n];
            // 处理边界，边界只有一种走法可以到
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            // 非边界的走法由子问题决定
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}