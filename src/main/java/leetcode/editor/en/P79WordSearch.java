//Given a 2D board and a word, find if the word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cell, where
// "adjacent" cells are those horizontally or vertically neighboring. The same let
//ter cell may not be used more than once. 
//
// Example: 
//
// 
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//Given word = "ABCCED", return true.
//Given word = "SEE", return true.
//Given word = "ABCB", return false.
// 
// Related Topics Array Backtracking

package leetcode.editor.en;

//Java：Word Search

public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            /**
             * 思路：外层循环把每个字符作为查找的第一个点
             * 内层进行递归，同时标记哪些路径已经被使用
             * 递归后发现不满足条件，则回溯到上一步,同时归还已使用标记
             */
            // 循环选择起始点
            for (int row = 0; row < board.length; row++) {
                for (int column = 0; column < board[row].length; column++) {
                    // 对每个起始点进行递归
                    if (exist(board, row, column, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        // 实际的递归操作
        private boolean exist(char[][] board, int row, int column, String word, int pos) {
            int len = word.length();
            if (pos == len) {
                return true;
            }
            // 处理边界
            if (row < 0 || row > board.length - 1
                    || column < 0 || column > board[0].length - 1
                    || board[row][column] != word.charAt(pos)) {
                return false;
            }
            // 标记位置已使用，使得后面的递归中不会再使用该位置
            board[row][column] = '*';
            boolean result = exist(board, row - 1, column, word, pos + 1)
                    || exist(board, row + 1, column, word, pos + 1)
                    || exist(board, row, column - 1, word, pos + 1)
                    || exist(board, row, column + 1, word, pos + 1);
            // 标记位重置
            board[row][column] = word.charAt(pos);
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}